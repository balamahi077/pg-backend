package com.pgmanagement.pgbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pgmanagement.pgbackend.entity.Payment;
import com.pgmanagement.pgbackend.repository.PaymentRepository;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment recordPayment(Payment payment) {
        // Automatically timestamp the payment when the caretaker logs it
        payment.setPaymentDate(LocalDateTime.now());
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    
    public List<Payment> getPaymentsByMonth(String monthYear) {
        return paymentRepository.findByMonthYear(monthYear);
    }
}
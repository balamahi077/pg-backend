package com.pgmanagement.pgbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pgmanagement.pgbackend.entity.Payment;
import com.pgmanagement.pgbackend.service.PaymentService;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment logPayment(@RequestBody Payment payment) {
        return paymentService.recordPayment(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }
    
    @GetMapping("/month/{monthYear}")
    public List<Payment> getPaymentsByMonth(@PathVariable String monthYear) {
        return paymentService.getPaymentsByMonth(monthYear);
    }
}
package com.pgmanagement.pgbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pgmanagement.pgbackend.entity.Payment;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Find all payments made by a specific tenant
    List<Payment> findByTenantId(Long tenantId);
    
    // Find all payments for a specific month
    List<Payment> findByMonthYear(String monthYear);
}
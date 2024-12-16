package com.of.rms.ordermanagement.repository;

import com.of.rms.ordermanagement.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}


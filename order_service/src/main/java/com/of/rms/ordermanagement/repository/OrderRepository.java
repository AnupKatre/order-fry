package com.of.rms.ordermanagement.repository;

import com.of.rms.ordermanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}


package com.of.rms.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository<OrderItem> extends JpaRepository<OrderItem, Long> {
}


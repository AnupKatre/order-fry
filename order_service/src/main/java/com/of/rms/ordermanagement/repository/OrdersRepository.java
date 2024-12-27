package com.of.rms.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByStatus(OrderStatus status);
    List<Orders> findByCustomerCustomerId(Long customerId);
}

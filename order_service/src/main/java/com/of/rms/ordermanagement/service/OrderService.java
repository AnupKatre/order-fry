package com.of.rms.ordermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Autowired
    private TablesRepository tablesRepository;

    // Create a new order
    @Transactional
    public Orders createOrder(Orders order, List<OrderItems> items) {
        // Save the order
        Orders savedOrder = ordersRepository.save(order);

        // Save order items
        for (OrderItems item : items) {
            item.setOrder(savedOrder);
            orderItemsRepository.save(item);
        }
        return savedOrder;
    }

    // Update an existing order
    @Transactional
    public Orders updateOrder(Long orderId, Orders updatedOrder) {
        Optional<Orders> existingOrderOpt = ordersRepository.findById(orderId);
        if (existingOrderOpt.isEmpty()) {
            throw new RuntimeException("Order not found");
        }
        Orders existingOrder = existingOrderOpt.get();

        // Update order details
        existingOrder.setStatus(updatedOrder.getStatus());
        existingOrder.setPaymentStatus(updatedOrder.getPaymentStatus());
        existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
        return ordersRepository.save(existingOrder);
    }

    // Get order by ID
    public Orders getOrderById(Long orderId) {
        return ordersRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // Get all orders
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    // Get orders by customer
    public List<Orders> getOrdersByCustomer(Long customerId) {
        return ordersRepository.findByCustomerCustomerId(customerId);
    }

    // Delete an order
    @Transactional
    public void deleteOrder(Long orderId) {
        ordersRepository.deleteById(orderId);
    }

    // Update table status
    @Transactional
    public Tables updateTableStatus(Long tableId, TableStatus status) {
        Tables table = tablesRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("Table not found"));
        table.setStatus(status);
        return tablesRepository.save(table);
    }
}

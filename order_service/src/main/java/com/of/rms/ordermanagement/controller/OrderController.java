package com.of.rms.ordermanagement.controller;

import com.of.rms.common.enums.TableStatus;
import com.of.rms.common.model.OrderItems;
import com.of.rms.common.model.Orders;
import com.of.rms.common.model.Tables;
import com.of.rms.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Create a new order
    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order, @RequestBody List<OrderItems> items) {
        Orders savedOrder = orderService.createOrder(order, items);
        return ResponseEntity.ok(savedOrder);
    }

    // Update an order
    @PutMapping("/{orderId}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Long orderId, @RequestBody Orders updatedOrder) {
        Orders updated = orderService.updateOrder(orderId, updatedOrder);
        return ResponseEntity.ok(updated);
    }

    // Get order by ID
    @GetMapping("/{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long orderId) {
        Orders order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    // Get all orders
    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // Get orders by customer
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Orders>> getOrdersByCustomer(@PathVariable Long customerId) {
        List<Orders> orders = orderService.getOrdersByCustomer(customerId);
        return ResponseEntity.ok(orders);
    }

    // Delete an order
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    // Update table status
    @PutMapping("/tables/{tableId}/status")
    public ResponseEntity<Tables> updateTableStatus(@PathVariable Long tableId, @RequestParam TableStatus status) {
        Tables updatedTable = orderService.updateTableStatus(tableId, status);
        return ResponseEntity.ok(updatedTable);
    }
}

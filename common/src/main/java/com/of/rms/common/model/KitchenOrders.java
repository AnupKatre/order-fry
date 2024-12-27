package com.of.rms.common.model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "kitchen_orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KitchenOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kitchenOrderId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    private String specialInstructions;

    @Enumerated(EnumType.STRING)
    private KitchenOrderStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}

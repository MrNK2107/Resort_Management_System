package com.resortmanagement.system.fnb.entity;

import com.resortmanagement.system.common.audit.AuditableSoftDeletable;
import com.resortmanagement.system.common.enums.OrderStatus;
import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order extends AuditableSoftDeletable {

    @Id
    @GeneratedValue
    private UUID id;

    /**
     * Guest placing the order (walk-in orders may not have this)
     */
    @Column(name = "guest_id")
    private UUID guestId;

    /**
     * Reservation context (nullable for POS orders)
     */
    @Column(name = "reservation_id")
    private UUID reservationId;

    /**
     * Table reference for restaurant orders
     */
    // @Column(name = "table_id")
    // private UUID tableId;
    
    // Adding tableId properly if needed, but commented out in original. 
    // DTO had tableId though! OrderRequest had tableId.
    // OrderResponse had tableId.
    // If I map to Entity, Entity MUST have tableId if I want to persist it.
    // I will enable tableId column to match DTO usage.
    
    @Column(name = "table_id")
    private UUID tableId;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal totalAmount = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private Instant placedAt;

    /**
     * Linked folio for billing (nullable until billed)
     */
    @Column(name = "assigned_folio_id")
    private UUID assignedFolioId;

    /**
     * Order → OrderItem (bidirectional)
     */
    @SuppressWarnings("rawtypes")
    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Set<OrderItem> orderItems = new HashSet<>();

    // Manual Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getGuestId() {
        return guestId;
    }

    public void setGuestId(UUID guestId) {
        this.guestId = guestId;
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public void setReservationId(UUID reservationId) {
        this.reservationId = reservationId;
    }

    public UUID getTableId() {
        return tableId;
    }

    public void setTableId(UUID tableId) {
        this.tableId = tableId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Instant getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(Instant placedAt) {
        this.placedAt = placedAt;
    }

    public UUID getAssignedFolioId() {
        return assignedFolioId;
    }

    public void setAssignedFolioId(UUID assignedFolioId) {
        this.assignedFolioId = assignedFolioId;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}

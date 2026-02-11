package com.resortmanagement.system.fnb.controller;

import com.resortmanagement.system.fnb.entity.OrderItem;
import com.resortmanagement.system.fnb.service.OrderItemService;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/fnb/order-items")
public class OrderItemController {

    private final OrderItemService service;

    public OrderItemController(OrderItemService service) {
        this.service = service;
    }

    /**
     * Get all active order items
     */
    @GetMapping
    public ResponseEntity<@Nullable Object> getAllActive() {
        return ResponseEntity.ok(service.findAllActive());
    }

    /**
     * Get order item by ID
     */
    @SuppressWarnings("rawtypes")
    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getById(@PathVariable UUID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Create a new order item
     * (Usually created via OrderService when creating an Order)
     */
    @SuppressWarnings("rawtypes")
    @PostMapping
    public ResponseEntity<OrderItem> create(@RequestBody OrderItem orderItem) {
        OrderItem saved = service.save(orderItem);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /**
     * Update an existing order item
     */
    @SuppressWarnings("rawtypes")
    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> update(
            @PathVariable UUID id,
            @RequestBody OrderItem orderItem) {

        orderItem.setId(id);
        return ResponseEntity.ok(service.save(orderItem));
    }

    /**
     * Soft delete order item
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


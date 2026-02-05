/*
TODO: OrderController.java
Purpose:
 - POS endpoints for creating Orders linked to guest/reservation tables.
Endpoints:
 - POST /api/v1/orders -> create order (guestId, reservationId, items)
 - GET /api/v1/orders/{id}
 - POST /api/v1/orders/{id}/confirm -> confirm and deduct inventory (transactional)
Responsibilities:
 - Validate item availability and inventory before confirming.
 - Use OrderService for transaction (deduct inventory atomically; rollback on failure).
 - Assign Order to folio for billing.

File: fnb/controller/OrderController.java
*/
package com.resortmanagement.system.fnb.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resortmanagement.system.fnb.entity.Order;
import com.resortmanagement.system.fnb.service.OrderService;

@RestController
@RequestMapping("/api/fnb/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id) {
        return this.orderService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.orderService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.orderService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

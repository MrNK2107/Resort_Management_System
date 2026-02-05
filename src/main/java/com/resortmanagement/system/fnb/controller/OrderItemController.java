/*
TODO: OrderItemController.java
Purpose:
 - Manage order line items (usually part of Order POST payload; separate endpoints for updates if needed).
Responsibilities:
 - Validate menu item exists and record unit_price snapshot.
 - OrderService should create OrderItem records and later confirm order to deduct inventory.
File: fnb/controller/OrderItemController.java
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

import com.resortmanagement.system.fnb.entity.OrderItem;
import com.resortmanagement.system.fnb.service.OrderItemService;

@RestController
@RequestMapping("/api/fnb/orderitems")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping
    public ResponseEntity<List<OrderItem>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.orderItemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getById(@PathVariable Long id) {
        return this.orderItemService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrderItem> create(@RequestBody OrderItem entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.orderItemService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> update(@PathVariable Long id, @RequestBody OrderItem entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.orderItemService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.orderItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

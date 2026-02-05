/*
TODO: InventoryTransactionController.java
Purpose:
 - Endpoint to view inventory transactions and perform manual adjustments (admin).
Endpoints:
 - GET /api/v1/inventory/transactions?itemId=...
 - POST /api/v1/inventory/transactions/manual -> admin adjustment
Responsibilities:
 - Only admin/warehouse role allowed to adjust.
 - Service records transactions and updates quantity atomically.

File: inventory/controller/InventoryTransactionController.java
*/
package com.resortmanagement.system.inventory.controller;


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

import com.resortmanagement.system.inventory.entity.InventoryTransaction;
import com.resortmanagement.system.inventory.service.InventoryTransactionService;

@RestController
@RequestMapping("/api/inventory/transactions")
public class InventoryTransactionController {

    private final InventoryTransactionService service;

    public InventoryTransactionController(InventoryTransactionService inventoryTransactionService) {
        this.service = inventoryTransactionService;
    }

    @GetMapping
    public ResponseEntity<List<InventoryTransaction>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryTransaction> getById(@PathVariable Long id) {
        return this.service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InventoryTransaction> create(@RequestBody InventoryTransaction entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryTransaction> update(@PathVariable Long id, @RequestBody InventoryTransaction entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

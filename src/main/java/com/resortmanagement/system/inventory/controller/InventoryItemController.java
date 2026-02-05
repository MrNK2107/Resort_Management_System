/*
TODO: InventoryItemController.java
Purpose:
 - CRUD for inventory items and quick queries (low stock).
Endpoints:
 - GET /api/v1/inventory/items?lowStock=true
 - POST /api/v1/inventory/items
 - PATCH /api/v1/inventory/items/{id}/adjust
Responsibilities:
 - Validate unit consistency; baseUnit per item.
 - Use InventoryItemService for atomic updates.
File: inventory/controller/InventoryItemController.java
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

import com.resortmanagement.system.inventory.entity.InventoryItem;
import com.resortmanagement.system.inventory.service.InventoryItemService;

@RestController
@RequestMapping("/api/inventory/items")
public class InventoryItemController {

    private final InventoryItemService service;

    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.service = inventoryItemService;
    }

    @GetMapping
    public ResponseEntity<List<InventoryItem>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItem> getById(@PathVariable Long id) {
        return this.service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InventoryItem> create(@RequestBody InventoryItem entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryItem> update(@PathVariable Long id, @RequestBody InventoryItem entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

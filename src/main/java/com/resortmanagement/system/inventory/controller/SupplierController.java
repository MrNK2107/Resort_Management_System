/*
TODO: SupplierController.java
Purpose:
 - CRUD for suppliers and search.
Endpoints:
 - POST /api/v1/suppliers
 - GET /api/v1/suppliers/{id}
 - GET /api/v1/suppliers?name=
File: inventory/controller/SupplierController.java
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

import com.resortmanagement.system.inventory.entity.Supplier;
import com.resortmanagement.system.inventory.service.SupplierService;

@RestController
@RequestMapping("/api/inventory/suppliers")
public class SupplierController {

    private final SupplierService service;

    public SupplierController(SupplierService supplierService) {
        this.service = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getById(@PathVariable Long id) {
        return this.service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Supplier> create(@RequestBody Supplier entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> update(@PathVariable Long id, @RequestBody Supplier entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

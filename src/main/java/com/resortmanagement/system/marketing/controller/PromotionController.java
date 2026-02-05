/*
TODO: PromotionController.java
Purpose:
 - CRUD for promotions/coupons.
Endpoints:
 - POST /api/v1/promotions
 - GET /api/v1/promotions?code=...
Responsibilities:
 - Apply promotion rules in pricing service at booking/invoice computation time.
File: marketing/controller/PromotionController.java
*/
package com.resortmanagement.system.marketing.controller;


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

import com.resortmanagement.system.marketing.entity.Promotion;
import com.resortmanagement.system.marketing.service.PromotionService;

@RestController
@RequestMapping("/api/marketing/promotions")
public class PromotionController {

    private final PromotionService service;

    public PromotionController(PromotionService promotionService) {
        this.service = promotionService;
    }

    @GetMapping
    public ResponseEntity<List<Promotion>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getById(@PathVariable Long id) {
        return this.service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Promotion> create(@RequestBody Promotion entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promotion> update(@PathVariable Long id, @RequestBody Promotion entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

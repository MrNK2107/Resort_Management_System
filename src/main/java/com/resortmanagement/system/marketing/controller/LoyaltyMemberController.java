/*
TODO: LoyaltyMemberController.java
Purpose:
 - Manage loyalty program members and points.
Endpoints:
 - POST /api/v1/loyalty -> enroll member
 - GET /api/v1/loyalty/{id}
 - POST /api/v1/loyalty/{id}/adjust-points
Responsibilities:
 - Keep points arithmetic in service; maintain transactional integrity.
 - Protect endpoints for admin when adjusting points.
File: marketing/controller/LoyaltyMemberController.java
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

import com.resortmanagement.system.marketing.entity.LoyaltyMember;
import com.resortmanagement.system.marketing.service.LoyaltyMemberService;

@RestController
@RequestMapping("/api/marketing/loyaltymembers")
public class LoyaltyMemberController {

    private final LoyaltyMemberService service;

    public LoyaltyMemberController(LoyaltyMemberService loyaltyMemberService) {
        this.service = loyaltyMemberService;
    }

    @GetMapping
    public ResponseEntity<List<LoyaltyMember>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoyaltyMember> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LoyaltyMember> create(@RequestBody LoyaltyMember entity) {
        // TODO: add validation
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoyaltyMember> update(@PathVariable Long id, @RequestBody LoyaltyMember entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

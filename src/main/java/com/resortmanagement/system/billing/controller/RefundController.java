/**
TODO: RefundController.java
Purpose:
 - Expose endpoints to create refunds against payments/invoices.
Endpoints:
 - POST /api/v1/payments/{paymentId}/refund -> create refund request (amount, reason)
 - GET /api/v1/refunds/{refundId}
Responsibilities:
 - Validate refund business rules (amount <= refundable).
 - Use RefundService (transaction) to create refund record, call PSP refund API, update Payment/Invoice statuses.
 - Use proper RBAC (finance/admin only).
File: billing/controller/RefundController.java
 */
package com.resortmanagement.system.billing.controller;

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

import com.resortmanagement.system.billing.entity.Refund;
import com.resortmanagement.system.billing.service.RefundService;

@RestController
@RequestMapping("/api/billing/refunds")
public class RefundController {

    private final RefundService refundService;

    public RefundController(RefundService refundService) {
        this.refundService = refundService;
    }

    @GetMapping
    public ResponseEntity<List<Refund>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(refundService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refund> getById(@PathVariable Long id) {
        return refundService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Refund> create(@RequestBody Refund refund) {
        // TODO: add validation
        return ResponseEntity.ok(refundService.save(refund));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Refund> update(@PathVariable Long id, @RequestBody Refund refund) {
        // TODO: implement update logic
        return ResponseEntity.ok(refundService.save(refund));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        refundService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

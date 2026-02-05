/**
TODO: PaymentController.java
Purpose:
 - Accept payment requests and forward to PaymentService; handle idempotency and webhooks.
Endpoints:
 - POST /api/v1/invoices/{invoiceId}/pay -> client triggers payment
 - POST /api/v1/payments/webhook -> PSP webhook endpoint (idempotent)
 - GET /api/v1/payments/{paymentId}
Responsibilities:
 - Use PaymentRequest DTO containing paymentMethod, token, amount, idempotencyKey.
 - Validate amounts match invoice outstanding.
 - Use PaymentService (transactional) for recording Payment and updating Invoice status.
 - Secure webhook with signature check and idempotency key handling.

File: billing/controller/PaymentController.java
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

import com.resortmanagement.system.billing.entity.Payment;
import com.resortmanagement.system.billing.service.PaymentService;

@RestController
@RequestMapping("/api/billing/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(paymentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getById(@PathVariable Long id) {
        return paymentService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        // TODO: add validation
        return ResponseEntity.ok(paymentService.save(payment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(@PathVariable Long id, @RequestBody Payment payment) {
        // TODO: implement update logic
        return ResponseEntity.ok(paymentService.save(payment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paymentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

/**
TODO: InvoiceController.java
Purpose:
 - REST endpoints for invoice life cycle: create invoice from folio, get invoice, list invoices, mark paid/refund.
Suggested endpoints:
 - POST /api/v1/folios/{folioId}/invoices -> create invoice
 - GET /api/v1/invoices/{invoiceId}
 - POST /api/v1/invoices/{invoiceId}/pay -> invoke PSP through PaymentService
 - POST /api/v1/invoices/{invoiceId}/refund -> create refund

Responsibilities:
 - Use DTOs: CreateInvoiceRequest, InvoiceResponse, PaymentRequest.
 - Input validation (currency consistency, amounts).
 - Delegate to InvoiceService for transactional work.
 - Ensure invoice persistence uses ReservationDailyRate and folio line items.

File: billing/controller/InvoiceController.java
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

import com.resortmanagement.system.billing.entity.Invoice;
import com.resortmanagement.system.billing.service.InvoiceService;

@RestController
@RequestMapping("/api/billing/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(invoiceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getById(@PathVariable Long id) {
        return invoiceService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Invoice> create(@RequestBody Invoice invoice) {
        // TODO: add validation
        return ResponseEntity.ok(invoiceService.save(invoice));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> update(@PathVariable Long id, @RequestBody Invoice invoice) {
        // TODO: implement update logic
        return ResponseEntity.ok(invoiceService.save(invoice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        invoiceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

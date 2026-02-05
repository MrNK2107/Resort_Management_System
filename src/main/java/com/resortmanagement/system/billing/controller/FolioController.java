/**
TODO: FolioController.java
Purpose:
 - Expose folio operations for a reservation: list folios, create folio, attach items, close folio.
Suggested endpoints:
 - GET /api/v1/reservations/{reservationId}/folios
 - POST /api/v1/reservations/{reservationId}/folios  (create main folio or additional folio)
 - POST /api/v1/folios/{folioId}/assign-item  (assign Order/Service/Addon to folio)
 - POST /api/v1/folios/{folioId}/invoice  (generate invoice for folio)

Responsibilities:
 - Validate guest/reservation existence before invoking service.
 - Use DTOs (FolioRequest, FolioResponse, AssignItemRequest).
 - Ensure that folio creation and assignments are transactional in service layer.
 - Use @PreAuthorize for access control (frontdesk, finance).

File: billing/controller/FolioController.java
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

import com.resortmanagement.system.billing.entity.Folio;
import com.resortmanagement.system.billing.service.FolioService;

@RestController
@RequestMapping("/api/billing/folios")
public class FolioController {

    private final FolioService folioService;

    public FolioController(FolioService folioService) {
        this.folioService = folioService;
    }

    @GetMapping
    public ResponseEntity<List<Folio>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(folioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Folio> getById(@PathVariable Long id) {
        return folioService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Folio> create(@RequestBody Folio folio) {
        // TODO: add validation
        return ResponseEntity.ok(folioService.save(folio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Folio> update(@PathVariable Long id, @RequestBody Folio folio) {
        // TODO: implement update logic
        return ResponseEntity.ok(folioService.save(folio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        folioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

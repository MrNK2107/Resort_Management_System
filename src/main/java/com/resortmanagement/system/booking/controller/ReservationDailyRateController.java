/*
TODO: ReservationDailyRateController.java
Purpose:
 - Endpoints for maintenance/inspection of daily rates (admin read-only), not general CRUD.
Suggested endpoints:
 - GET /api/v1/reservations/{id}/daily-rates
Responsibilities:
 - Query ReservationDailyRateService to return per-night breakdown for invoices and for UI display.
 - Ensure immutability: do not provide endpoint to modify snapshot rates (admin adjustments go via credits/adjustments).

File: booking/controller/ReservationDailyRateController.java
*/

package com.resortmanagement.system.booking.controller;

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

import com.resortmanagement.system.booking.entity.ReservationDailyRate;
import com.resortmanagement.system.booking.service.ReservationDailyRateService;

@RestController
@RequestMapping("/api/booking/reservationdailyrates")
public class ReservationDailyRateController {

    private final ReservationDailyRateService service;

    public ReservationDailyRateController(ReservationDailyRateService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReservationDailyRate>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDailyRate> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReservationDailyRate> create(@RequestBody ReservationDailyRate entity) {
        // TODO: add validation
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDailyRate> update(@PathVariable Long id, @RequestBody ReservationDailyRate entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

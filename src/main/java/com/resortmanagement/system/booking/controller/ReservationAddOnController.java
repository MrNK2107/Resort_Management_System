/*
TODO: ReservationAddOnController.java
Purpose:
 - Manage add-ons attached to reservations (e.g., breakfast, airport pickup).
Endpoints:
 - POST /api/v1/reservations/{id}/addons -> add an add-on
 - GET /api/v1/reservations/{id}/addons
 - DELETE /api/v1/reservations/{id}/addons/{addonId}
Responsibilities:
 - Use ReservationAddOnService (transactional).
 - Validate pricing and apply to folio.
 - DTOs: ReservationAddOnRequest, ReservationAddOnResponse.

File: booking/controller/ReservationAddOnController.java
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

import com.resortmanagement.system.booking.entity.ReservationAddOn;
import com.resortmanagement.system.booking.service.ReservationAddOnService;

@RestController
@RequestMapping("/api/booking/reservationaddons")
public class ReservationAddOnController {

    private final ReservationAddOnService service;

    public ReservationAddOnController(ReservationAddOnService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReservationAddOn>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationAddOn> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReservationAddOn> create(@RequestBody ReservationAddOn entity) {
        // TODO: add validation
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationAddOn> update(@PathVariable Long id, @RequestBody ReservationAddOn entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

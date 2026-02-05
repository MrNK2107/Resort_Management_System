/*
TODO: ReservationController.java
Purpose:
 - Core booking endpoints: create reservation, modify, confirm, cancel, checkin, checkout.
Suggested endpoints:
 - POST /api/v1/reservations -> create reservation (CreateReservationRequest)
 - GET /api/v1/reservations/{id}
 - POST /api/v1/reservations/{id}/confirm
 - POST /api/v1/reservations/{id}/cancel
 - POST /api/v1/reservations/{id}/checkin
 - POST /api/v1/reservations/{id}/checkout
Responsibilities:
 - Validate request DTOs and call ReservationService.
 - Return ReservationResponse DTO (never entity).
 - Use proper HTTP codes (201 created, 202 accepted for async, 409 for no availability).
 - Implement PATCH endpoints for partial updates if necessary.
Security:
 - restrict checkin/checkout to ROLE_FRONTDESK or ROLE_MANAGER.

File: booking/controller/ReservationController.java
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

import com.resortmanagement.system.booking.entity.Reservation;
import com.resortmanagement.system.booking.service.ReservationService;

@RestController
@RequestMapping("/api/booking/reservations")
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody Reservation entity) {
        // TODO: add validation
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> update(@PathVariable Long id, @RequestBody Reservation entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

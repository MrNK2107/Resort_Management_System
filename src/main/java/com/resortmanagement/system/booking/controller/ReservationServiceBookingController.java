/*
TODO: ReservationServiceBookingController.java
Purpose:
 - Expose endpoints for services (staff-delivered) associated to reservations (spa, shuttle).
Endpoints:
 - POST /api/v1/reservations/{id}/services -> schedule a service
 - GET /api/v1/reservations/{id}/services
Responsibilities:
 - Validate service availability with ServiceItemService.
 - Create ReservationServiceBooking entries via ReservationServiceBookingService (transactional).
 - Assign service to folio for billing.
File: booking/controller/ReservationServiceBookingController.java
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

import com.resortmanagement.system.booking.entity.ReservationServiceBooking;
import com.resortmanagement.system.booking.service.ReservationServiceBookingService;

@RestController
@RequestMapping("/api/booking/reservationservicebookings")
public class ReservationServiceBookingController {

    private final ReservationServiceBookingService service;

    public ReservationServiceBookingController(ReservationServiceBookingService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReservationServiceBooking>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationServiceBooking> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReservationServiceBooking> create(@RequestBody ReservationServiceBooking entity) {
        // TODO: add validation
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationServiceBooking> update(@PathVariable Long id, @RequestBody ReservationServiceBooking entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

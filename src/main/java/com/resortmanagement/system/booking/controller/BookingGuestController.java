/*
TODO: BookingGuestController.java
Purpose:
 - CRUD endpoints for booking guest records (booking/occupant details).
Endpoints:
 - POST /api/v1/reservations/{reservationId}/guests -> add guest to reservation
 - GET /api/v1/reservations/{reservationId}/guests -> list guests
 - DELETE /api/v1/reservations/{reservationId}/guests/{id} -> remove guest

Responsibilities:
 - Validate booking occupancy limits against roomType.maxOccupancy.
 - Use BookingGuestService for transactional updates.
 - DTOs: BookingGuestRequest, BookingGuestResponse.
 - Use proper status codes and handle 409 when over-capacity.

File: booking/controller/BookingGuestController.java
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

import com.resortmanagement.system.booking.entity.BookingGuest;
import com.resortmanagement.system.booking.service.BookingGuestService;

@RestController
@RequestMapping("/api/booking/bookingguests")
public class BookingGuestController {

    private final BookingGuestService service;

    public BookingGuestController(BookingGuestService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BookingGuest>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingGuest> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookingGuest> create(@RequestBody BookingGuest entity) {
        // TODO: add validation
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingGuest> update(@PathVariable Long id, @RequestBody BookingGuest entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

/*
TODO: RoomAmenityController.java
Purpose:
 - Manage list of amenities and association to rooms.
Endpoints:
 - POST /api/v1/room-amenities
 - GET /api/v1/rooms/{id}/amenities
File: room/controller/RoomAmenityController.java
*/
package com.resortmanagement.system.room.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.resortmanagement.system.room.service.RoomAmenityService;
import com.resortmanagement.system.room.entity.RoomAmenity;

@RestController
@RequestMapping("/api/room/roomamenities")
public class RoomAmenityController {

    private final RoomAmenityService service;

    public RoomAmenityController(RoomAmenityService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RoomAmenity>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomAmenity> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RoomAmenity> create(@RequestBody RoomAmenity entity) {
        // TODO: add validation
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomAmenity> update(@PathVariable Long id, @RequestBody RoomAmenity entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

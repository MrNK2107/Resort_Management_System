/*
TODO: RoomTypeController.java
Purpose:
 - Manage room types (Deluxe, Suite) and base info.
Endpoints:
 - POST /api/v1/room-types
 - GET /api/v1/room-types
Responsibilities:
 - RoomTypeService handles base rate and amenities summary; pricing handled by RatePlan.
File: room/controller/RoomTypeController.java
*/
package com.resortmanagement.system.room.controller;

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

import com.resortmanagement.system.room.entity.RoomType;
import com.resortmanagement.system.room.service.RoomTypeService;

@RestController
@RequestMapping("/api/room-types")
public class RoomTypeController {

    private final RoomTypeService service;

    public RoomTypeController(RoomTypeService service) {
        this.service = service;
    }

    @PostMapping
    public RoomType create(@RequestBody RoomType roomType) {
        return service.create(roomType);
    }

    @GetMapping
    public List<RoomType> getAll() {
        return service.getAll();
    }
}


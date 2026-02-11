package com.resortmanagement.system.room.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.resortmanagement.system.room.dto.request.AmenityCreateRequest;
import com.resortmanagement.system.room.dto.request.AmenityUpdateRequest;
import com.resortmanagement.system.room.dto.response.AmenityResponse;
import com.resortmanagement.system.room.service.AmenityService;

@RestController
@RequestMapping("/api/amenities")
public class AmenityController {

    private final AmenityService service;

    public AmenityController(AmenityService service) {
        this.service = service;
    }

    @PostMapping
    public AmenityResponse create(@RequestBody AmenityCreateRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<AmenityResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AmenityResponse get(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public AmenityResponse update(
            @PathVariable UUID id,
            @RequestBody AmenityUpdateRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}

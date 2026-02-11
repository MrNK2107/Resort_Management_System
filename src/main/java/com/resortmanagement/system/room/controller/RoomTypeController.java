package com.resortmanagement.system.room.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.resortmanagement.system.room.dto.request.RoomTypeCreateRequest;
import com.resortmanagement.system.room.dto.request.RoomTypeUpdateRequest;
import com.resortmanagement.system.room.dto.response.RoomTypeResponse;
import com.resortmanagement.system.room.service.RoomTypeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/room-types")
public class RoomTypeController {

    private final RoomTypeService service;

    public RoomTypeController(RoomTypeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomTypeResponse create(@Valid @RequestBody RoomTypeCreateRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<RoomTypeResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RoomTypeResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public RoomTypeResponse update(@PathVariable UUID id,
                                   @RequestBody RoomTypeUpdateRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}

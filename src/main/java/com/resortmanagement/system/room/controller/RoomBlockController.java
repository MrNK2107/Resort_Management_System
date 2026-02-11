package com.resortmanagement.system.room.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.resortmanagement.system.room.dto.request.RoomBlockCreateRequest;
import com.resortmanagement.system.room.dto.request.RoomBlockUpdateRequest;
import com.resortmanagement.system.room.dto.response.RoomBlockResponse;
import com.resortmanagement.system.room.service.RoomBlockService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/room-blocks")
public class RoomBlockController {

    private final RoomBlockService service;

    public RoomBlockController(RoomBlockService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomBlockResponse create(@Valid @RequestBody RoomBlockCreateRequest dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<RoomBlockResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RoomBlockResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public RoomBlockResponse update(@PathVariable UUID id,
                                    @RequestBody RoomBlockUpdateRequest dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}

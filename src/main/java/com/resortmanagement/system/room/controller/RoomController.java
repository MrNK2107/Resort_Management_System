package com.resortmanagement.system.room.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.resortmanagement.system.room.dto.request.RoomCreateRequest;
import com.resortmanagement.system.room.dto.request.RoomUpdateRequest;
import com.resortmanagement.system.room.dto.response.RoomResponse;
import com.resortmanagement.system.room.service.RoomService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    // Manual constructor (since no Lombok @RequiredArgsConstructor)
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomResponse create(@Valid @RequestBody RoomCreateRequest request) {
        return roomService.create(request);
    }

    // GET ALL
    @GetMapping
    public List<RoomResponse> getAll() {
        return roomService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public RoomResponse getById(@PathVariable UUID id) {
        return roomService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public RoomResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody RoomUpdateRequest request) { // <-- @Valid added
        return roomService.updateRoom(id, request);
    }

    // SOFT DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        roomService.deleteRoom(id);
    }
}

package com.resortmanagement.system.room.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.resortmanagement.system.room.dto.request.MaintenanceRequestCreateRequest;
import com.resortmanagement.system.room.dto.response.MaintenanceRequestResponse;
import com.resortmanagement.system.room.service.MaintenanceRequestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceRequestController {

    private final MaintenanceRequestService service;

    public MaintenanceRequestController(MaintenanceRequestService service) {
        this.service = service;
    }

    @PostMapping
    public MaintenanceRequestResponse create(
            @Valid @RequestBody MaintenanceRequestCreateRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<MaintenanceRequestResponse> open() {
        return service.getAllOpen();
    }

    @DeleteMapping("/{id}")
    public void close(@PathVariable UUID id) {
        service.close(id);
    }
}

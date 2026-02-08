/*
TODO: MaintenanceRequestController.java
Purpose:
 - Manage maintenance reports and link to RoomBlock to prevent bookings.
Endpoints:
 - POST /api/v1/maintenance -> report issue
 - POST /api/v1/maintenance/{id}/take -> assign engineer
 - POST /api/v1/maintenance/{id}/resolve
Responsibilities:
 - On critical issues create RoomBlock entries to mark room OOO; notify relevant staff via events.
File: room/controller/MaintenanceRequestController.java
*/
package com.resortmanagement.system.room.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resortmanagement.system.room.entity.MaintenanceRequest;
import com.resortmanagement.system.room.service.MaintenanceRequestService;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceRequestController {

    private final MaintenanceRequestService service;

    public MaintenanceRequestController(MaintenanceRequestService service) {
        this.service = service;
    }

    @PostMapping
    public MaintenanceRequest create(@RequestBody MaintenanceRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<MaintenanceRequest> open() {
        return service.getAllOpen();
    }

    @DeleteMapping("/{id}")
    public void close(@PathVariable UUID id) {
        service.close(id);
    }
}


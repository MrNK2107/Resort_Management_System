/*
TODO: ActivityEventController.java
Purpose:
 - CRUD and scheduling endpoints for activities (yoga, diving, shows).
Endpoints:
 - POST /api/v1/activities -> create scheduled event
 - GET /api/v1/activities?date=...
 - POST /api/v1/activities/{id}/register -> assign guest(s)
Responsibilities:
 - Validate capacity, check instructor availability.
 - Use ActivityEventService for transactional scheduling.
 - Map to DTOs.

File: fnb/controller/ActivityEventController.java
*/
package com.resortmanagement.system.fnb.controller;

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

import com.resortmanagement.system.fnb.entity.ActivityEvent;
import com.resortmanagement.system.fnb.service.ActivityEventService;

@RestController
@RequestMapping("/api/fnb/activityevents")
public class ActivityEventController {

    private final ActivityEventService activityEventService;

    public ActivityEventController(ActivityEventService activityEventService) {
        this.activityEventService = activityEventService;
    }

    @GetMapping
    public ResponseEntity<List<ActivityEvent>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.activityEventService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityEvent> getById(@PathVariable Long id) {
        return this.activityEventService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ActivityEvent> create(@RequestBody ActivityEvent entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.activityEventService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityEvent> update(@PathVariable Long id, @RequestBody ActivityEvent entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.activityEventService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.activityEventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

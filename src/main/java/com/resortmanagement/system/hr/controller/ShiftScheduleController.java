/*
TODO: ShiftScheduleController.java
Purpose:
 - Manage shift assignments for staff across departments.
Endpoints:
 - POST /api/v1/shifts -> create shift assignment
 - GET /api/v1/employees/{id}/shifts
Responsibilities:
 - Validate overlapping shifts and employee availability.
 - Use ShiftScheduleService for conflict detection and persistence.

File: hr/controller/ShiftScheduleController.java
*/
package com.resortmanagement.system.hr.controller;

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

import com.resortmanagement.system.hr.entity.ShiftSchedule;
import com.resortmanagement.system.hr.service.ShiftScheduleService;

@RestController
@RequestMapping("/api/hr/shiftschedules")
public class ShiftScheduleController {

    private final ShiftScheduleService shiftScheduleService;

    public ShiftScheduleController(ShiftScheduleService shiftScheduleService) {
        this.shiftScheduleService = shiftScheduleService;
    }

    @GetMapping
    public ResponseEntity<List<ShiftSchedule>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.shiftScheduleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShiftSchedule> getById(@PathVariable Long id) {
        return this.shiftScheduleService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ShiftSchedule> create(@RequestBody ShiftSchedule entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.shiftScheduleService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShiftSchedule> update(@PathVariable Long id, @RequestBody ShiftSchedule entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.shiftScheduleService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.shiftScheduleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.resortmanagement.system.hr.controller;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.resortmanagement.system.hr.dto.shiftschedule.ShiftScheduleRequest;
import com.resortmanagement.system.hr.dto.shiftschedule.ShiftScheduleResponse;
import com.resortmanagement.system.hr.service.ShiftScheduleService;

@RestController
@RequestMapping("/api/hr/shift-schedules")
public class ShiftScheduleController {

    private final ShiftScheduleService service;

    public ShiftScheduleController(ShiftScheduleService shiftScheduleService) {
        this.service = shiftScheduleService;
    }

    @GetMapping
    public ResponseEntity<Page<ShiftScheduleResponse>> getAllShiftSchedules(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShiftScheduleResponse> getShiftScheduleById(@PathVariable UUID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ShiftScheduleResponse> createShiftSchedule(@RequestBody ShiftScheduleRequest request) {
        ShiftScheduleResponse created = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShiftScheduleResponse> updateShiftSchedule(
            @PathVariable UUID id,
            @RequestBody ShiftScheduleRequest request) {
        ShiftScheduleResponse updated = service.update(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShiftSchedule(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Page<ShiftScheduleResponse>> getShiftSchedulesByEmployee(
            @PathVariable UUID employeeId,
            Pageable pageable) {
        return ResponseEntity.ok(service.findByEmployeeId(employeeId, pageable));
    }

    @GetMapping("/range")
    public ResponseEntity<Page<ShiftScheduleResponse>> getShiftSchedulesByTimeRange(
            @RequestParam Instant startTime,
            @RequestParam Instant endTime,
            Pageable pageable) {
        return ResponseEntity.ok(service.findByTimeRange(startTime, endTime, pageable));
    }
}

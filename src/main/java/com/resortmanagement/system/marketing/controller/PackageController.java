/*
TODO: PackageController.java
Purpose:
 - Manage packages (room + services bundles).
Endpoints:
 - POST /api/v1/packages
 - GET /api/v1/packages
 - POST /api/v1/packages/{id}/book -> apply package as reservation-level operation
Responsibilities:
 - When booked, expand package into ReservationDailyRate + ReservationAddOn + ReservationServiceBooking via BookingService/factory.
File: marketing/controller/PackageController.java
*/
package com.resortmanagement.system.marketing.controller;


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

import com.resortmanagement.system.marketing.entity.Package;
import com.resortmanagement.system.marketing.service.PackageService;

@RestController
@RequestMapping("/api/marketing/packages")
public class PackageController {

    private final PackageService service;

    public PackageController(PackageService packageService) {
        this.service = packageService;
    }

    @GetMapping
    public ResponseEntity<List<Package>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Package> getById(@PathVariable Long id) {
        return this.service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Package> create(@RequestBody Package entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Package> update(@PathVariable Long id, @RequestBody Package entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

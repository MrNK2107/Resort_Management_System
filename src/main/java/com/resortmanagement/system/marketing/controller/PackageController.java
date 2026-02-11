package com.resortmanagement.system.marketing.controller;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.resortmanagement.system.marketing.dto.packagedto.PackageRequest;
import com.resortmanagement.system.marketing.dto.packagedto.PackageResponse;
import com.resortmanagement.system.marketing.service.PackageService;

@RestController
@RequestMapping("/api/marketing/packages")
public class PackageController {

    private final PackageService service;

    public PackageController(PackageService packageService) {
        this.service = packageService;
    }

    @GetMapping
    public ResponseEntity<Page<PackageResponse>> getAllPackages(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackageResponse> getPackageById(@PathVariable UUID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PackageResponse> createPackage(@RequestBody PackageRequest request) {
        PackageResponse created = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PackageResponse> updatePackage(
            @PathVariable UUID id,
            @RequestBody PackageRequest request) {
        PackageResponse updated = service.update(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

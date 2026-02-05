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

import com.resortmanagement.system.marketing.entity.PackageItem;
import com.resortmanagement.system.marketing.service.PackageItemService;

@RestController
@RequestMapping("/api/marketing/packageitems")
public class PackageItemController {

    private final PackageItemService service;

    public PackageItemController(PackageItemService packageItemService) {
        this.service = packageItemService;
    }

    @GetMapping
    public ResponseEntity<List<PackageItem>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackageItem> getById(@PathVariable Long id) {
        return this.service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PackageItem> create(@RequestBody PackageItem entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PackageItem> update(@PathVariable Long id, @RequestBody PackageItem entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

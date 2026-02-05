/*
TODO: MenuController.java
Purpose:
 - Manage menus and menu grouping (Breakfast, Bar).
Endpoints:
 - POST /api/v1/menus
 - GET /api/v1/menus
 - GET /api/v1/menus/{id}
Responsibilities:
 - Minimal logic; MenuService handles creation and item assignment.
File: fnb/controller/MenuController.java
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

import com.resortmanagement.system.fnb.entity.Menu;
import com.resortmanagement.system.fnb.service.MenuService;

@RestController
@RequestMapping("/api/fnb/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<List<Menu>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.menuService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getById(@PathVariable Long id) {
        return this.menuService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Menu> create(@RequestBody Menu entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.menuService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> update(@PathVariable Long id, @RequestBody Menu entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.menuService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.menuService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

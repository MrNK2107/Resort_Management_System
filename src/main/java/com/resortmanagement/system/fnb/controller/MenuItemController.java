/*
TODO: MenuItemController.java
Purpose:
 - Manage menu items (create, update availability).
Endpoints:
 - POST /api/v1/menus/{menuId}/items
 - GET /api/v1/menu-items/{id}
 - PATCH /api/v1/menu-items/{id}/availability
Responsibilities:
 - On create/update, validate price, ingredients linking, and inventory units.

File: fnb/controller/MenuItemController.java
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

import com.resortmanagement.system.fnb.entity.MenuItem;
import com.resortmanagement.system.fnb.service.MenuItemService;

@RestController
@RequestMapping("/api/fnb/menuitems")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public ResponseEntity<List<MenuItem>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.menuItemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getById(@PathVariable Long id) {
        return this.menuItemService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MenuItem> create(@RequestBody MenuItem entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.menuItemService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> update(@PathVariable Long id, @RequestBody MenuItem entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.menuItemService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.menuItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

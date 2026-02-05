/*
TODO: MenuItemIngredientController.java
Purpose:
 - Admin endpoints to configure recipe mapping between menu items and inventory items.
Endpoints:
 - POST /api/v1/menu-items/{id}/ingredients
Responsibilities:
 - Manage conversions (store quantity in inventory base unit).
 - Use MenuItemIngredientService to update mapping and run inventory impact checks if required.

File: fnb/controller/MenuItemIngredientController.java
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

import com.resortmanagement.system.fnb.entity.MenuItemIngredient;
import com.resortmanagement.system.fnb.service.MenuItemIngredientService;

@RestController
@RequestMapping("/api/fnb/menuitemingredients")
public class MenuItemIngredientController {

    private final MenuItemIngredientService service;

    public MenuItemIngredientController(MenuItemIngredientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MenuItemIngredient>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemIngredient> getById(@PathVariable Long id) {
        return this.service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MenuItemIngredient> create(@RequestBody MenuItemIngredient entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItemIngredient> update(@PathVariable Long id, @RequestBody MenuItemIngredient entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

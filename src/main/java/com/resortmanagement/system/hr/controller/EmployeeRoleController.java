/*
TODO: EmployeeRoleController.java
Purpose:
 - Manage role assignments, roles list.
Endpoints:
 - GET /api/v1/roles
 - POST /api/v1/employees/{id}/roles -> assign role
Responsibilities:
 - Use RoleService and EmployeeRoleService for transactional operations.
File: hr/controller/EmployeeRoleController.java
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

import com.resortmanagement.system.hr.entity.EmployeeRole;
import com.resortmanagement.system.hr.service.EmployeeRoleService;

@RestController
@RequestMapping("/api/hr/employeeroles")
public class EmployeeRoleController {

    private final EmployeeRoleService employeeRoleService;

    public EmployeeRoleController(EmployeeRoleService employeeRoleService) {
        this.employeeRoleService = employeeRoleService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeRole>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.employeeRoleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeRole> getById(@PathVariable Long id) {
        return this.employeeRoleService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmployeeRole> create(@RequestBody EmployeeRole entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.employeeRoleService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeRole> update(@PathVariable Long id, @RequestBody EmployeeRole entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.employeeRoleService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.employeeRoleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

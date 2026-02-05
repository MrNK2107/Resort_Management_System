/*
TODO: EmployeeController.java
Purpose:
 - CRUD and lookup for employees.
Endpoints:
 - POST /api/v1/employees -> create employee (secure)
 - GET /api/v1/employees/{id}
 - PUT /api/v1/employees/{id}
 - GET /api/v1/employees?role=...
Responsibilities:
 - Do not return sensitive fields (password hash).
 - Use EmployeeService; map to DTOs.
File: hr/controller/EmployeeController.java
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

import com.resortmanagement.system.hr.entity.Employee;
import com.resortmanagement.system.hr.service.EmployeeService;

@RestController
@RequestMapping("/api/hr/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return this.employeeService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.employeeService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.employeeService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

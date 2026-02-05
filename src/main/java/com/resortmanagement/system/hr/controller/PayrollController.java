/*
TODO: PayrollController.java
Purpose:
 - Endpoints for payroll processing and payouts (admin only).
Endpoints:
 - POST /api/v1/payrolls/generate?period=yyyy-MM -> run payroll for period
 - GET /api/v1/payrolls/{id}
Responsibilities:
 - Payroll generation is heavy: implement as async job, produce reports, and store payroll records.
 - Keep payroll sensitive; restrict access.

File: hr/controller/PayrollController.java
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

import com.resortmanagement.system.hr.entity.Payroll;
import com.resortmanagement.system.hr.service.PayrollService;

@RestController
@RequestMapping("/api/hr/payrolls")
public class PayrollController {

    private final PayrollService payrollService;

    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @GetMapping
    public ResponseEntity<List<Payroll>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(this.payrollService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payroll> getById(@PathVariable Long id) {
        return this.payrollService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Payroll> create(@RequestBody Payroll entity) {
        // TODO: add validation
        return ResponseEntity.ok(this.payrollService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payroll> update(@PathVariable Long id, @RequestBody Payroll entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(this.payrollService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.payrollService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

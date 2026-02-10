package com.resortmanagement.system.hr.controller;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.resortmanagement.system.hr.dto.payroll.PayrollRequest;
import com.resortmanagement.system.hr.dto.payroll.PayrollResponse;
import com.resortmanagement.system.hr.service.PayrollService;

@RestController
@RequestMapping("/api/hr/payrolls")
public class PayrollController {

    private final PayrollService service;

    public PayrollController(PayrollService payrollService) {
        this.service = payrollService;
    }

    @GetMapping
    public ResponseEntity<Page<PayrollResponse>> getAllPayrolls(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayrollResponse> getPayrollById(@PathVariable UUID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PayrollResponse> createPayroll(@RequestBody PayrollRequest request) {
        PayrollResponse created = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayrollResponse> updatePayroll(
            @PathVariable UUID id,
            @RequestBody PayrollRequest request) {
        PayrollResponse updated = service.update(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Page<PayrollResponse>> getPayrollsByEmployee(
            @PathVariable UUID employeeId,
            Pageable pageable) {
        return ResponseEntity.ok(service.findByEmployeeId(employeeId, pageable));
    }
}

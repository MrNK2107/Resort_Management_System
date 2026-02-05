package com.resortmanagement.system.hr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.hr.entity.Payroll;
import com.resortmanagement.system.hr.repository.PayrollRepository;

@Service
public class PayrollService {

    private final PayrollRepository repository;

    public PayrollService(PayrollRepository repository) {
        this.repository = repository;
    }

    public List<Payroll> findAll() {
        // TODO: add pagination and filtering
        return repository.findAll();
    }

    public Optional<Payroll> findById(Long id) {
        // TODO: add caching and error handling
        return repository.findById(id);
    }

    public Payroll save(Payroll entity) {
        // TODO: add validation and business rules
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        // TODO: add soft delete if required
        repository.deleteById(id);
    }
}

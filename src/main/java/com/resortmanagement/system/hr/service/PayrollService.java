package com.resortmanagement.system.hr.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resortmanagement.system.hr.dto.payroll.PayrollRequest;
import com.resortmanagement.system.hr.dto.payroll.PayrollResponse;
import com.resortmanagement.system.hr.entity.Payroll;
import com.resortmanagement.system.hr.mapper.PayrollMapper;
import com.resortmanagement.system.hr.repository.PayrollRepository;

@Service
@Transactional
public class PayrollService {

    private final PayrollRepository repository;
    private final PayrollMapper mapper;

    public PayrollService(PayrollRepository payrollRepository, PayrollMapper payrollMapper) {
        this.repository = payrollRepository;
        this.mapper = payrollMapper;
    }

    @Transactional(readOnly = true)
    public Page<PayrollResponse> findAll(Pageable pageable) {
        return repository.findByDeletedFalse(pageable).map(mapper::toResponse);
    }

    @Transactional(readOnly = true)
    public Optional<PayrollResponse> findById(UUID id) {
        return repository.findByIdAndDeletedFalse(id).map(mapper::toResponse);
    }

    public PayrollResponse save(PayrollRequest dto) {
        if (dto.getEmployeeId() == null) {
            throw new IllegalArgumentException("Employee ID is required");
        }
        if (dto.getPeriodStart() == null) {
            throw new IllegalArgumentException("Period start is required");
        }
        if (dto.getPeriodEnd() == null) {
            throw new IllegalArgumentException("Period end is required");
        }

        Payroll payroll = mapper.toEntity(dto);
        Payroll saved = repository.save(payroll);
        return mapper.toResponse(saved);
    }

    public PayrollResponse update(UUID id, PayrollRequest dto) {
        return repository.findByIdAndDeletedFalse(id)
                .map(existing -> {
                    mapper.updateEntity(existing, dto);
                    return mapper.toResponse(repository.save(existing));
                })
                .orElseThrow(() -> new RuntimeException("Payroll not found with id " + id));
    }

    public void deleteById(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Payroll not found with id " + id);
        }
        repository.softDeleteById(id, Instant.now());
    }

    @Transactional(readOnly = true)
    public Page<PayrollResponse> findByEmployeeId(UUID employeeId, Pageable pageable) {
        return repository.findByEmployee_IdAndDeletedFalse(employeeId, pageable)
                .map(mapper::toResponse);
    }
}

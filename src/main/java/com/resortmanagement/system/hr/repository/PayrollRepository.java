package com.resortmanagement.system.hr.repository;

import com.resortmanagement.system.common.repository.SoftDeleteRepository;
import com.resortmanagement.system.hr.entity.Payroll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PayrollRepository extends SoftDeleteRepository<Payroll, UUID> {

    // Find by employee with pagination and soft delete check
    Page<Payroll> findByEmployee_IdAndDeletedFalse(UUID employeeId, Pageable pageable);

    // Find by deleted status with pagination
    Page<Payroll> findByDeletedFalse(Pageable pageable);

    // Find by ID with soft delete check
    Optional<Payroll> findByIdAndDeletedFalse(UUID id);
}

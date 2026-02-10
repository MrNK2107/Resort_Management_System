package com.resortmanagement.system.hr.repository;

import com.resortmanagement.system.common.repository.SoftDeleteRepository;
import com.resortmanagement.system.hr.entity.ShiftSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShiftScheduleRepository extends SoftDeleteRepository<ShiftSchedule, UUID> {

    // Find by deleted status with pagination
    Page<ShiftSchedule> findByDeletedFalse(Pageable pageable);

    // Find by ID with soft delete check
    Optional<ShiftSchedule> findByIdAndDeletedFalse(UUID id);

    // Find by employee with pagination and soft delete check
    Page<ShiftSchedule> findByEmployee_IdAndDeletedFalse(UUID employeeId, Pageable pageable);

    // Find shifts within time range with soft delete check
    Page<ShiftSchedule> findByStartTimeBetweenAndDeletedFalse(Instant startTime, Instant endTime, Pageable pageable);
}

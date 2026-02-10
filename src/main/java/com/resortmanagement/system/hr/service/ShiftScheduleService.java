package com.resortmanagement.system.hr.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resortmanagement.system.hr.dto.shiftschedule.ShiftScheduleRequest;
import com.resortmanagement.system.hr.dto.shiftschedule.ShiftScheduleResponse;
import com.resortmanagement.system.hr.entity.ShiftSchedule;
import com.resortmanagement.system.hr.mapper.ShiftScheduleMapper;
import com.resortmanagement.system.hr.repository.ShiftScheduleRepository;

@Service
@Transactional
public class ShiftScheduleService {

    private final ShiftScheduleRepository repository;
    private final ShiftScheduleMapper mapper;

    public ShiftScheduleService(ShiftScheduleRepository shiftScheduleRepository,
            ShiftScheduleMapper shiftScheduleMapper) {
        this.repository = shiftScheduleRepository;
        this.mapper = shiftScheduleMapper;
    }

    @Transactional(readOnly = true)
    public Page<ShiftScheduleResponse> findAll(Pageable pageable) {
        return repository.findByDeletedFalse(pageable).map(mapper::toResponse);
    }

    @Transactional(readOnly = true)
    public Optional<ShiftScheduleResponse> findById(UUID id) {
        return repository.findByIdAndDeletedFalse(id).map(mapper::toResponse);
    }

    public ShiftScheduleResponse save(ShiftScheduleRequest dto) {
        if (dto.getEmployeeId() == null) {
            throw new IllegalArgumentException("Employee ID is required");
        }
        if (dto.getStartTime() == null) {
            throw new IllegalArgumentException("Start time is required");
        }
        if (dto.getEndTime() == null) {
            throw new IllegalArgumentException("End time is required");
        }

        ShiftSchedule shiftSchedule = mapper.toEntity(dto);
        ShiftSchedule saved = repository.save(shiftSchedule);
        return mapper.toResponse(saved);
    }

    public ShiftScheduleResponse update(UUID id, ShiftScheduleRequest dto) {
        return repository.findByIdAndDeletedFalse(id)
                .map(existing -> {
                    mapper.updateEntity(existing, dto);
                    return mapper.toResponse(repository.save(existing));
                })
                .orElseThrow(() -> new RuntimeException("ShiftSchedule not found with id " + id));
    }

    public void deleteById(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("ShiftSchedule not found with id " + id);
        }
        repository.softDeleteById(id, Instant.now());
    }

    @Transactional(readOnly = true)
    public Page<ShiftScheduleResponse> findByEmployeeId(UUID employeeId, Pageable pageable) {
        return repository.findByEmployee_IdAndDeletedFalse(employeeId, pageable)
                .map(mapper::toResponse);
    }

    @Transactional(readOnly = true)
    public Page<ShiftScheduleResponse> findByTimeRange(Instant startTime, Instant endTime, Pageable pageable) {
        return repository.findByStartTimeBetweenAndDeletedFalse(startTime, endTime, pageable)
                .map(mapper::toResponse);
    }
}

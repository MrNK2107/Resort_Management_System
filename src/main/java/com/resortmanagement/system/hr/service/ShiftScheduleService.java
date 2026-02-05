package com.resortmanagement.system.hr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.hr.entity.ShiftSchedule;
import com.resortmanagement.system.hr.repository.ShiftScheduleRepository;

@Service
public class ShiftScheduleService {

    private final ShiftScheduleRepository repository;

    public ShiftScheduleService(ShiftScheduleRepository repository) {
        this.repository = repository;
    }

    public List<ShiftSchedule> findAll() {
        // TODO: add pagination and filtering
        return repository.findAll();
    }

    public Optional<ShiftSchedule> findById(Long id) {
        // TODO: add caching and error handling
        return repository.findById(id);
    }

    public ShiftSchedule save(ShiftSchedule entity) {
        // TODO: add validation and business rules
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        // TODO: add soft delete if required
        repository.deleteById(id);
    }
}

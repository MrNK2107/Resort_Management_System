package com.resortmanagement.system.room.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.room.entity.HousekeepingTask;
import com.resortmanagement.system.room.repository.HousekeepingTaskRepository;

@Service
public class HousekeepingTaskService {

    private final HousekeepingTaskRepository repository;

    public HousekeepingTaskService(HousekeepingTaskRepository repository) {
        this.repository = repository;
    }

    public HousekeepingTask create(HousekeepingTask task) {
        return repository.save(task);
    }

    public List<HousekeepingTask> getPending() {
        return repository.findByDeletedFalse();
    }

    public void complete(UUID id) {
        repository.softDeleteById(id, Instant.now());
    }
}

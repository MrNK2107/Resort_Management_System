package com.resortmanagement.system.room.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.room.entity.MaintenanceRequest;
import com.resortmanagement.system.room.repository.MaintenanceRequestRepository;

@Service
public class MaintenanceRequestService {

    private final MaintenanceRequestRepository repository;

    public MaintenanceRequestService(MaintenanceRequestRepository repository) {
        this.repository = repository;
    }

    public MaintenanceRequest create(MaintenanceRequest request) {
        return repository.save(request);
    }

    public List<MaintenanceRequest> getAllOpen() {
        return repository.findByDeletedFalse();
    }

    public void close(UUID id) {
        repository.softDeleteById(id, Instant.now());
    }
}


package com.resortmanagement.system.room.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.booking.repository.BookingGuestRepository;
import com.resortmanagement.system.room.dto.request.MaintenanceRequestCreateRequest;
import com.resortmanagement.system.room.dto.response.MaintenanceRequestResponse;
import com.resortmanagement.system.room.entity.MaintenanceRequest;
import com.resortmanagement.system.room.mapper.MaintenanceRequestMapper;
import com.resortmanagement.system.room.repository.MaintenanceRequestRepository;

@Service
public class MaintenanceRequestService {

    private final MaintenanceRequestRepository repository;
    private final BookingGuestRepository guestRepository;

    public MaintenanceRequestService(
            MaintenanceRequestRepository repository,
            BookingGuestRepository guestRepository) {
        this.repository = repository;
        this.guestRepository = guestRepository;
    }

    public MaintenanceRequestResponse create(MaintenanceRequestCreateRequest request) {
        MaintenanceRequest entity = MaintenanceRequestMapper.toEntity(request, guestRepository);
        MaintenanceRequest saved = repository.save(entity);
        return MaintenanceRequestMapper.toResponse(saved);
    }

    public List<MaintenanceRequestResponse> getAllOpen() {
        return MaintenanceRequestMapper.toResponseList(repository.findByDeletedFalse());
    }

    public void close(UUID id) {
        MaintenanceRequest entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("MaintenanceRequest not found"));
        entity.setDeleted(true);
        entity.setResolvedAt(LocalDateTime.now());
        repository.save(entity);
    }
}

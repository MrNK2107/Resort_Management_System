package com.resortmanagement.system.room.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.room.dto.request.RoomBlockCreateRequest;
import com.resortmanagement.system.room.dto.request.RoomBlockUpdateRequest;
import com.resortmanagement.system.room.dto.response.RoomBlockResponse;
import com.resortmanagement.system.room.entity.RoomBlock;
import com.resortmanagement.system.room.mapper.RoomBlockMapper;
import com.resortmanagement.system.room.repository.RoomBlockRepository;

@Service
public class RoomBlockService {

    private final RoomBlockRepository repository;

    public RoomBlockService(RoomBlockRepository repository) {
        this.repository = repository;
    }

    public RoomBlockResponse create(RoomBlockCreateRequest dto) {
        RoomBlock entity = RoomBlockMapper.toEntity(dto);
        RoomBlock saved = repository.save(entity);
        return RoomBlockMapper.toResponse(saved);
    }

    public List<RoomBlockResponse> getAll() {
        return RoomBlockMapper.toResponseList(repository.findByDeletedFalse());
    }

    public RoomBlockResponse getById(UUID id) {
        RoomBlock entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomBlock not found"));
        return RoomBlockMapper.toResponse(entity);
    }

    public RoomBlockResponse update(UUID id, RoomBlockUpdateRequest dto) {
        RoomBlock entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomBlock not found"));
        RoomBlockMapper.updateEntity(entity, dto);
        RoomBlock saved = repository.save(entity);
        return RoomBlockMapper.toResponse(saved);
    }

    public void delete(UUID id) {
        RoomBlock entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomBlock not found"));
        entity.setDeleted(true);
        repository.save(entity);
    }
}

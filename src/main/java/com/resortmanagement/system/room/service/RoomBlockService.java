package com.resortmanagement.system.room.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.room.entity.RoomBlock;
import com.resortmanagement.system.room.repository.RoomBlockRepository;

@Service
public class RoomBlockService {

    private final RoomBlockRepository repository;

    public RoomBlockService(RoomBlockRepository repository) {
        this.repository = repository;
    }

    public RoomBlock block(RoomBlock block) {
        return repository.save(block);
    }

    public List<RoomBlock> getActiveBlocks() {
        return repository.findByDeletedFalse();
    }

    public void unblock(UUID id) {
        repository.softDeleteById(id, Instant.now());
    }
}


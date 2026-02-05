package com.resortmanagement.system.room.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.resortmanagement.system.room.repository.RoomTypeRepository;
import com.resortmanagement.system.room.entity.RoomType;

@Service
public class RoomTypeService {

    private final RoomTypeRepository repository;

    public RoomTypeService(RoomTypeRepository repository) {
        this.repository = repository;
    }

    public List<RoomType> findAll() {
        // TODO: add pagination and filtering
        return repository.findAll();
    }

    public Optional<RoomType> findById(Long id) {
        // TODO: add caching and error handling
        return repository.findById(id);
    }

    public RoomType save(RoomType entity) {
        // TODO: add validation and business rules
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        // TODO: add soft delete if required
        repository.deleteById(id);
    }
}

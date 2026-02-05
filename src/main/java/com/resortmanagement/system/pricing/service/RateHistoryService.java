package com.resortmanagement.system.pricing.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.resortmanagement.system.pricing.repository.RateHistoryRepository;
import com.resortmanagement.system.pricing.entity.RateHistory;

@Service
public class RateHistoryService {

    private final RateHistoryRepository repository;

    public RateHistoryService(RateHistoryRepository repository) {
        this.repository = repository;
    }

    public List<RateHistory> findAll() {
        // TODO: add pagination and filtering
        return repository.findAll();
    }

    public Optional<RateHistory> findById(Long id) {
        // TODO: add caching and error handling
        return repository.findById(id);
    }

    public RateHistory save(RateHistory entity) {
        // TODO: add validation and business rules
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        // TODO: add soft delete if required
        repository.deleteById(id);
    }
}

package com.resortmanagement.system.marketing.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.resortmanagement.system.marketing.repository.PackageItemRepository;
import com.resortmanagement.system.marketing.entity.PackageItem;

@Service
public class PackageItemService {

    private final PackageItemRepository repository;

    public PackageItemService(PackageItemRepository repository) {
        this.repository = repository;
    }

    public List<PackageItem> findAll() {
        // TODO: add pagination and filtering
        return repository.findAll();
    }

    public Optional<PackageItem> findById(Long id) {
        // TODO: add caching and error handling
        return repository.findById(id);
    }

    public PackageItem save(PackageItem entity) {
        // TODO: add validation and business rules
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        // TODO: add soft delete if required
        repository.deleteById(id);
    }
}

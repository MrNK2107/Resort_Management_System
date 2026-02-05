package com.resortmanagement.system.fnb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.fnb.entity.MenuItem;
import com.resortmanagement.system.fnb.repository.MenuItemRepository;

@Service
public class MenuItemService {

    private final MenuItemRepository repository;

    public MenuItemService(MenuItemRepository repository) {
        this.repository = repository;
    }

    public List<MenuItem> findAll() {
        // TODO: add pagination and filtering
        return repository.findAll();
    }

    public Optional<MenuItem> findById(Long id) {
        // TODO: add caching and error handling
        return repository.findById(id);
    }

    public MenuItem save(MenuItem entity) {
        // TODO: add validation and business rules
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        // TODO: add soft delete if required
        repository.deleteById(id);
    }
}

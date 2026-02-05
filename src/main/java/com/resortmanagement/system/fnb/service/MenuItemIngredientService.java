package com.resortmanagement.system.fnb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.fnb.entity.MenuItemIngredient;
import com.resortmanagement.system.fnb.repository.MenuItemIngredientRepository;

@Service
public class MenuItemIngredientService {

    private final MenuItemIngredientRepository repository;

    public MenuItemIngredientService(MenuItemIngredientRepository repository) {
        this.repository = repository;
    }

    public List<MenuItemIngredient> findAll() {
        // TODO: add pagination and filtering
        return repository.findAll();
    }

    public Optional<MenuItemIngredient> findById(Long id) {
        // TODO: add caching and error handling
        return repository.findById(id);
    }

    public MenuItemIngredient save(MenuItemIngredient entity) {
        // TODO: add validation and business rules
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        // TODO: add soft delete if required
        repository.deleteById(id);
    }
}

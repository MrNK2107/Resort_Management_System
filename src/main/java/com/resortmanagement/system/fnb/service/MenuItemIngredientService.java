package com.resortmanagement.system.fnb.service;

import com.resortmanagement.system.fnb.entity.MenuItemIngredient;
import com.resortmanagement.system.fnb.repository.MenuItemIngredientRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MenuItemIngredientService {

    private final MenuItemIngredientRepository repository;

    public MenuItemIngredientService(MenuItemIngredientRepository repository) {
        this.repository = repository;
    }

    public List<MenuItemIngredient> findAll() {
        return repository.findAll();
    }

    public Optional<MenuItemIngredient> findById(UUID id) {
        return repository.findById(id);
    }

    public List<MenuItemIngredient> findByMenuItem(UUID menuItemId) {
        return repository.findByMenuItemId(menuItemId);
    }

    public MenuItemIngredient save(MenuItemIngredient entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

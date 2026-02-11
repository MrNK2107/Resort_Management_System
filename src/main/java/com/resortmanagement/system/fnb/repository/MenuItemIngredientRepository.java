package com.resortmanagement.system.fnb.repository;

import com.resortmanagement.system.fnb.entity.MenuItemIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuItemIngredientRepository
        extends JpaRepository<MenuItemIngredient, UUID> {

    List<MenuItemIngredient> findByMenuItemId(UUID menuItemId);
}

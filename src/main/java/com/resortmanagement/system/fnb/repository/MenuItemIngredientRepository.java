package com.resortmanagement.system.fnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.fnb.entity.MenuItemIngredient;

@Repository
public interface MenuItemIngredientRepository extends JpaRepository<MenuItemIngredient, Long> {
    // TODO: add custom queries if needed
}

package com.resortmanagement.system.fnb.dto.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

// import lombok.Data;

public class MenuItemResponse {
    private UUID id;
    private UUID menuId;
    private String menuName;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean isAvailable;
    private List<MenuItemIngredientResponse> ingredients;

    // Manual Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getMenuId() {
        return menuId;
    }

    public void setMenuId(UUID menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<MenuItemIngredientResponse> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<MenuItemIngredientResponse> ingredients) {
        this.ingredients = ingredients;
    }
}

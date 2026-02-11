package com.resortmanagement.system.fnb.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

// import lombok.Data;

public class MenuItemIngredientRequest {

    @NotNull(message = "Inventory item ID is required")
    private UUID inventoryItemId;

    @NotNull(message = "Quantity required is required")
    @Positive(message = "Quantity must be positive")
    private BigDecimal quantityRequired;

    @NotBlank(message = "Unit is required")
    private String unit;

    // Manual Getters and Setters

    public UUID getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(UUID inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public BigDecimal getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(BigDecimal quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

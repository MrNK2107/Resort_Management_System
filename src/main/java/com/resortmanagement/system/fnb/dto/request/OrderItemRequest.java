package com.resortmanagement.system.fnb.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

// import lombok.Data;

public class OrderItemRequest {

    @NotNull(message = "Menu item ID is required")
    private UUID menuItemId;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be positive")
    private int qty;

    // Manual Getters and Setters

    public UUID getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(UUID menuItemId) {
        this.menuItemId = menuItemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

package com.resortmanagement.system.inventory.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.resortmanagement.system.inventory.entity.InventorySourceType;

import jakarta.validation.constraints.NotNull;

// import lombok.Data;

public class InventoryTransactionRequest {

    @NotNull(message = "Inventory item ID is required")
    private UUID inventoryItemId;

    @NotNull(message = "Quantity change is required")
    private BigDecimal qtyChange;

    @NotNull(message = "Source type is required")
    private InventorySourceType sourceType;

    private UUID sourceId;

    // Manual Getters and Setters

    public UUID getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(UUID inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public BigDecimal getQtyChange() {
        return qtyChange;
    }

    public void setQtyChange(BigDecimal qtyChange) {
        this.qtyChange = qtyChange;
    }

    public InventorySourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(InventorySourceType sourceType) {
        this.sourceType = sourceType;
    }

    public UUID getSourceId() {
        return sourceId;
    }

    public void setSourceId(UUID sourceId) {
        this.sourceId = sourceId;
    }
}

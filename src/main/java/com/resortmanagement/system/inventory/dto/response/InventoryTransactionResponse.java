package com.resortmanagement.system.inventory.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

import com.resortmanagement.system.inventory.entity.InventorySourceType;

// import lombok.Data;

public class InventoryTransactionResponse {
    private UUID id;
    private UUID inventoryItemId;
    private String inventoryItemName;
    private BigDecimal qtyChange;
    private InventorySourceType sourceType;
    private UUID sourceId;

    // Manual Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(UUID inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getInventoryItemName() {
        return inventoryItemName;
    }

    public void setInventoryItemName(String inventoryItemName) {
        this.inventoryItemName = inventoryItemName;
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

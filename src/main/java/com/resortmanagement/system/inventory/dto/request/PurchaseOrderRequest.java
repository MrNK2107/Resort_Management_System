package com.resortmanagement.system.inventory.dto.request;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

// import lombok.Data;

public class PurchaseOrderRequest {

    @NotNull(message = "Supplier ID is required")
    private UUID supplierId;

    private Instant expectedDelivery;

    @NotEmpty(message = "Purchase order must have at least one line")
    @Valid
    private List<PurchaseOrderLineRequest> lines;

    // Manual Getters and Setters

    public UUID getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(UUID supplierId) {
        this.supplierId = supplierId;
    }

    public Instant getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(Instant expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public List<PurchaseOrderLineRequest> getLines() {
        return lines;
    }

    public void setLines(List<PurchaseOrderLineRequest> lines) {
        this.lines = lines;
    }
}

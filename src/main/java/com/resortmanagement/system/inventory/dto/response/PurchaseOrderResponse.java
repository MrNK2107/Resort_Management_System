package com.resortmanagement.system.inventory.dto.response;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.resortmanagement.system.inventory.entity.PurchaseOrderStatus;

// import lombok.Data;

public class PurchaseOrderResponse {
    private UUID id;
    private String poNumber;
    private UUID supplierId;
    private String supplierName;
    private PurchaseOrderStatus status;
    private Instant expectedDelivery;
    private BigDecimal totalAmount;
    private List<PurchaseOrderLineResponse> lines;

    // Manual Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public UUID getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(UUID supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public PurchaseOrderStatus getStatus() {
        return status;
    }

    public void setStatus(PurchaseOrderStatus status) {
        this.status = status;
    }

    public Instant getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(Instant expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<PurchaseOrderLineResponse> getLines() {
        return lines;
    }

    public void setLines(List<PurchaseOrderLineResponse> lines) {
        this.lines = lines;
    }
}

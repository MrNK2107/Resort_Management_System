/*
TODO: PurchaseOrder.java
Purpose:
 - Purchase order header for supplier purchases.
Fields:
 - id UUID
 - poNumber String unique
 - supplierId UUID
 - status enum (CREATED, SENT, DELIVERED, CANCELLED)
 - expectedDelivery Instant
 - totalAmount BigDecimal
 - createdAt via Auditable
Notes:
 - Lines stored in PurchaseOrderLine.
File: inventory/entity/PurchaseOrder.java
*/
package com.resortmanagement.system.inventory.entity;

public class PurchaseOrder {
    // TODO: fields, constructors, getters, setters
}
/*
TODO: InventoryTransaction.java
Purpose:
 - Records stock in/out adjustments.
Fields:
 - id UUID
 - item: InventoryItem (ManyToOne)
 - qtyChange BigDecimal (positive for IN, negative for OUT)
 - sourceType enum (PURCHASE, ORDER, ADJUSTMENT, WASTAGE)
 - sourceId UUID (purchaseOrderId or orderId)
 - createdBy via Auditable
 - createdAt via Auditable
Notes:
 - When sourceType=ORDER, sourceId should reference Order id.
 - Service must use atomic UPDATE statement to change quantityOnHand and insert transaction; if any fail, rollback.
File: inventory/entity/InventoryTransaction.java
*/
package com.resortmanagement.system.inventory.entity;

public class InventoryTransaction {
    // TODO: fields, constructors, getters, setters
}
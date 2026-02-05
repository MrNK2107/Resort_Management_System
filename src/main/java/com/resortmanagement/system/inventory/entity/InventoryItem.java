/*
TODO: InventoryItem.java
Purpose:
 - Master inventory item entity.
Fields:
 - id UUID
 - sku String unique
 - name String
 - baseUnit String (g, kg, ml, piece)
 - quantityOnHand BigDecimal
 - reorderPoint BigDecimal
 - unitCost BigDecimal
 - extends Auditable
 - @Version for optimistic locking
Notes:
 - All quantity transactions must be reflected by InventoryTransaction entries.
File: inventory/entity/InventoryItem.java
*/
package com.resortmanagement.system.inventory.entity;

public class InventoryItem {
    // TODO: fields, constructors, getters, setters
}
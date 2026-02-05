/*
TODO: MenuItemIngredient.java
Purpose:
 - Recipe junction between MenuItem and InventoryItem.
Fields:
 - id: UUID
 - menuItem: MenuItem
 - inventoryItem: InventoryItem
 - quantityRequired: BigDecimal (in inventoryItem.baseUnit)
 - unit: String (human readable; do conversions at write-time)
Notes:
 - When an OrderItem created, multiply quantityRequired by order qty to compute inventory deduction.
File: fnb/entity/MenuItemIngredient.java
*/
package com.resortmanagement.system.fnb.entity;

public class MenuItemIngredient {
    // TODO: fields, constructors, getters, setters
}
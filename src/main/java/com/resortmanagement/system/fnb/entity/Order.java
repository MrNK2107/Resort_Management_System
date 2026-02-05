/*
TODO: Order.java
Purpose:
 - Represents an F&B order or POS sale.
Fields:
 - id UUID
 - guestId UUID (ManyToOne optional)
 - reservationId UUID (nullable)
 - tableId UUID (nullable)
 - totalAmount BigDecimal
 - status OrderStatus
 - placedAt Instant
 - assignedFolioId UUID (nullable)
 - extends Auditable
Behavior:
 - Creation of Order does NOT deduct inventory; confirmation does.
 - Use OrderService to handle confirm step: check MenuItemIngredient and create InventoryTransaction rows.

File: fnb/entity/Order.java
*/

package com.resortmanagement.system.fnb.entity;

public class Order {
    // TODO: fields, constructors, getters, setters
}
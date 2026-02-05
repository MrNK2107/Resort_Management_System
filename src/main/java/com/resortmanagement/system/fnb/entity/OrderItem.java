/*
TODO: OrderItem.java
Purpose:
 - Line item for Order.
Fields:
 - id UUID
 - order: Order (ManyToOne)
 - menuItem: MenuItem (FK)
 - qty: int
 - unitPrice: BigDecimal (snapshot)
 - totalPrice: BigDecimal (qty * unitPrice)
Notes:
 - On create, snapshot price from MenuItem and compute totals.
 - On order confirm, trigger inventory consumption for ingredients.

File: fnb/entity/OrderItem.java
*/
package com.resortmanagement.system.fnb.entity;

public class OrderItem {
    // TODO: fields, constructors, getters, setters
}
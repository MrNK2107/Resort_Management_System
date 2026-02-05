/*
TODO: MenuItem.java
Purpose:
 - A sellable food/drink item.
Fields:
 - id UUID
 - menu: Menu (ManyToOne)
 - name String
 - description String
 - price BigDecimal
 - isAvailable boolean
 - recipe/map to MenuItemIngredient entries (OneToMany)
 - extends Auditable (track who created/updated menu items)
Notes:
 - Do not contain inventory logic; connect via MenuItemIngredient.
File: fnb/entity/MenuItem.java
*/
package com.resortmanagement.system.fnb.entity;

public class MenuItem {
    // TODO: fields, constructors, getters, setters
}
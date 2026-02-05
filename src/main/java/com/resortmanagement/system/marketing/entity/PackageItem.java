/*
TODO: PackageItem.java
Purpose:
 - Items inside packages (one-of: room_type_id, service_item_id, menu_item_id).
Fields:
 - id UUID
 - packageId UUID
 - componentType String (ENUM)
 - componentId UUID
 - qty int
 - price BigDecimal (snapshot)
Notes:
 - Add DB CHECK that exactly one component field is set (if using separate columns) or implement one-of logic in service.
File: marketing/entity/PackageItem.java
*/
package com.resortmanagement.system.marketing.entity;

public class PackageItem {
    // TODO: fields, constructors, getters, setters
}
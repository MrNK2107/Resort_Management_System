/*
TODO: Promotion.java
Purpose:
 - Promotion definition.
Fields:
 - id UUID
 - code String unique
 - description
 - discountType enum (PERCENT, AMOUNT)
 - value BigDecimal
 - validFrom, validTo
 - usageLimit int
 - terms String
 - extends Auditable
Notes:
 - Track usage (e.g., PromoUsage table) to enforce usageLimit.
File: marketing/entity/Promotion.java
*/
package com.resortmanagement.system.marketing.entity;

public class Promotion {
    // TODO: fields, constructors, getters, setters
}
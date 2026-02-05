/*
TODO: RateHistory.java
Purpose:
 - Seasonal price entries for a RatePlan.
Fields:
 - id UUID
 - ratePlan: RatePlan (ManyToOne)
 - price BigDecimal
 - seasonName String
 - startDate LocalDate
 - endDate LocalDate
 - extends Auditable
Rules:
 - Prevent overlapping ranges for the same rate plan (validate in service).
File: pricing/entity/RateHistory.java
*/
package com.resortmanagement.system.pricing.entity;

public class RateHistory {
    // TODO: fields, constructors, getters, setters
}
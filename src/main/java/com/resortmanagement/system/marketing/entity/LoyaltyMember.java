/*
TODO: LoyaltyMember.java
Purpose:
 - Track loyalty points and tier for guests.
Fields:
 - id UUID
 - guestId UUID
 - tier String
 - pointsBalance BigDecimal (or long)
 - enrolledAt Instant
 - status enum (ACTIVE, SUSPENDED)
 - extends Auditable
Notes:
 - Provide methods in service to add/redeem points (transactional).
File: marketing/entity/LoyaltyMember.java
*/
package com.resortmanagement.system.marketing.entity;

public class LoyaltyMember {
    // TODO: fields, constructors, getters, setters
}
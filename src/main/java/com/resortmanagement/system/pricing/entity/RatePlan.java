/*
TODO: RatePlan.java
Purpose:
 - Rate plan that ties base price to room types and defines cancellation policy.
Fields:
 - id UUID
 - name String
 - description String
 - basePrice BigDecimal
 - cancellationPolicy String (or structured)
 - isRefundable boolean
 - minStayNights int
 - maxStayNights int
 - validFrom, validTo optional
 - extends Auditable
Notes:
 - Pricing calculation uses RateHistory + RatePlan + promotions -> ReservationDailyRate created by BookingService.
File: pricing/entity/RatePlan.java
*/
package com.resortmanagement.system.pricing.entity;

public class RatePlan {
    // TODO: fields, constructors, getters, setters
}
/*
TODO: ReservationServiceBooking.java
Purpose:
 - Entity linking Reservation to ServiceItem (scheduled service).
Fields:
 - id: UUID
 - reservation: Reservation
 - serviceItem: ServiceItem (ManyToOne)  -- from fnb
 - scheduledAt: Instant
 - quantity: int
 - price: BigDecimal (snapshot)
 - status: enum (SCHEDULED, COMPLETED, CANCELLED)
 - staffAssigned: Employee (nullable)
 - extends Auditable
Rules:
 - Pricing snapshotted at creation.
 - Cancellation policies applied by service layer.
File: booking/entity/ReservationServiceBooking.java
*/

package com.resortmanagement.system.booking.entity;

public class ReservationServiceBooking {
    // TODO: fields, constructors, getters, setters
}
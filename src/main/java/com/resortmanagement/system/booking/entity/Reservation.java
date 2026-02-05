/*
TODO: Reservation.java
Purpose:
 - Core reservation entity that locks the booking.
Fields & annotations:
 - @Entity @Table("reservation")
 - id: UUID
 - guest: Guest (@ManyToOne lazy) -> reference to common.entity.Guest
 - roomType: RoomType (@ManyToOne lazy) -> REQUIRED at booking confirmation
 - bookingSourceId: UUID (referrer or OTAs)
 - startDate, endDate: LocalDate (hotel local timezone; convert to UTC only for timestamps)
 - numGuests: int
 - status: ReservationStatus (ENUM) with @Enumerated(STRING)
 - assignedRoom: Room (nullable @ManyToOne)
 - ratePlan: RatePlan (@ManyToOne)
 - createdBy/updatedBy handled by Auditable -> extend Auditable
 - soft-delete fields (deleted, deletedAt) if you prefer to soft delete reservations
Constraints & behavior:
 - Add DB constraints (startDate <= endDate).
 - Enforce reservation.room_type_id is immutable after confirmation (service-level validation).
 - No heavy logic in entity.
Important concurrency:
 - availability checks in ReservationService should lock on roomtype or use Redis to avoid overbooking.
File: booking/entity/Reservation.java
*/

package com.resortmanagement.system.booking.entity;

public class Reservation {
    // TODO: fields, constructors, getters, setters
}
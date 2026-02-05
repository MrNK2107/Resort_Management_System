/*
TODO: ReservationDailyRate.java
Purpose:
 - Represents authoritative nightly price snapshot for a reservation.
Fields:
 - id: UUID
 - reservation: Reservation (ManyToOne)
 - date: LocalDate
 - amount: BigDecimal (final nightly charge)
 - ratePlanId: UUID (FK, optional)
 - rateHistoryId: UUID (FK, optional)
 - createdAt handled by Auditable (extend Auditable)
Constraints:
 - Unique constraint (reservation, date)
 - Immutable once written (service must enforce)
Behavior:
 - Only created by ReservationService during booking flow.

File: booking/entity/ReservationDailyRate.java
*/

package com.resortmanagement.system.booking.entity;

public class ReservationDailyRate {
    // TODO: fields, constructors, getters, setters
}
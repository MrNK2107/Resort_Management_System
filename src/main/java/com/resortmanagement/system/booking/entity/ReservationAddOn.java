/*
TODO: ReservationAddOn.java
Purpose:
 - Represents add-on items tied to a reservation.
Fields:
 - id: UUID
 - reservation: Reservation (ManyToOne)
 - addOnType: enum or reference to a product (prefer FK to a service or package component)
 - qty: int
 - price: BigDecimal (snapshot)
 - extends Auditable
Notes:
 - Add-on price must be snapshotted at creation and assigned to a folio.
 - Use validation: qty > 0.

File: booking/entity/ReservationAddOn.java
*/

package com.resortmanagement.system.booking.entity;

public class ReservationAddOn {
    // TODO: fields, constructors, getters, setters
}
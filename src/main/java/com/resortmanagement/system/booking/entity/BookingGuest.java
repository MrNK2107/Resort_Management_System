/*
TODO: BookingGuest.java
Purpose:
 - Junction entity for multiple guests per reservation.
Fields:
 - id: UUID
 - reservation: Reservation (@ManyToOne, LAZY)
 - guest: Guest (reference to common.entity.Guest)
 - isPrimary: boolean
 - age: Integer
 - specialNeeds: String
 - extends Auditable (tracking who added / changed occupant info)
Notes:
 - Validate fields (age >= 0).
 - Do NOT duplicate guest personal data here; reference Guest entity.
File: booking/entity/BookingGuest.java
*/

package com.resortmanagement.system.booking.entity;

public class BookingGuest {
    // TODO: fields, constructors, getters, setters
}
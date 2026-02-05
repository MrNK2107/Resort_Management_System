/*
TODO: ActivityEvent.java
Purpose:
 - Represents scheduled activities with capacity, price, instructor.
Fields: use class diagram
 - id: UUID
 - title: String
 - description: String
 - startTime: Instant
 - endTime: Instant
 - capacity: int
 - instructorId: UUID (Employee)
 - price: BigDecimal
 - status: enum (SCHEDULED, CANCELLED, COMPLETED)
 - extend Auditable (events are operational and traceable)
Notes:
 - When guests register, create Registration records (if needed) or reuse ReservationServiceBooking model if integrated.
File: fnb/entity/ActivityEvent.java
*/
package com.resortmanagement.system.fnb.entity;

public class ActivityEvent {
    // TODO: fields, constructors, getters, setters
}
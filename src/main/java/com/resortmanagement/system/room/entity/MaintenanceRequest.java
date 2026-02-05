/*
TODO: MaintenanceRequest.java
Purpose:
 - Track maintenance issues for rooms/facilities.
Fields:
 - id UUID
 - roomOrFacilityId UUID
 - reportedBy (guestId or employeeId)
 - description String
 - severity enum
 - status enum (REPORTED, IN_PROGRESS, RESOLVED, CLOSED)
 - resolvedAt Instant
 - extends Auditable
Notes:
 - Create RoomBlock when appropriate to prevent booking.
File: room/entity/MaintenanceRequest.java
*/
package com.resortmanagement.system.room.entity;

public class MaintenanceRequest {
    // TODO: fields, constructors, getters, setters
}
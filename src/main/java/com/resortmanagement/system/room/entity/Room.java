/*
TODO: Room.java
Purpose:
 - Physical room representation.
Fields:
 - id UUID
 - roomNumber String unique
 - roomType: RoomType (ManyToOne)
 - floor String
 - status RoomStatus (AVAILABLE, OCCUPIED, DIRTY, OUT_OF_SERVICE)
 - maxOccupancy int
 - description String
 - extends Auditable
Notes:
 - Do not store current_rate_id here; pricing belongs to RatePlan/RoomType.
File: room/entity/Room.java
*/
package com.resortmanagement.system.room.entity;

public class Room {
    // TODO: fields, constructors, getters, setters
}
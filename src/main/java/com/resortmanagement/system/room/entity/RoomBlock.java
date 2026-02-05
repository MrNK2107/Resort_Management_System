/*
TODO: RoomBlock.java
Purpose:
 - Represents out-of-service block for a room.
Fields:
 - id UUID
 - roomId UUID
 - startDate LocalDate
 - endDate LocalDate
 - reason String
 - createdBy via Auditable
Notes:
 - Availability queries must exclude rooms with overlapping RoomBlock ranges.
File: room/entity/RoomBlock.java
*/
package com.resortmanagement.system.room.entity;

public class RoomBlock {
    // TODO: fields, constructors, getters, setters
}
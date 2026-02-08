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

import java.util.UUID;

import com.resortmanagement.system.common.audit.Auditable;
import com.resortmanagement.system.room.enums.RoomStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rooms")
@Getter
@Setter
public class Room extends Auditable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "room_number", nullable = false, unique = true)
    private String roomNumber;

    private String floor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomStatus status;

    private String description;

    @Column(name = "max_occupancy")
    private Integer maxOccupancy;

    @Column(name = "room_type_id", nullable = false)
    private UUID roomTypeId;
}


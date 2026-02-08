/*
TODO: RoomAmenity.java
Purpose:
 - Join table or entity for amenity master data.
Fields:
 - id UUID
 - roomId UUID
 - amenityId UUID or amenityName String
Notes:
 - Keep amenity definitions in a separate table if you want to show icons or descriptions.
File: room/entity/RoomAmenity.java
*/
package com.resortmanagement.system.room.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "room_amenities",
    uniqueConstraints = @UniqueConstraint(columnNames = {"room_id", "amenity_id"})
)
@Getter
@Setter
public class RoomAmenity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID roomId;
    private UUID amenityId;

    private Boolean complimentary;
}


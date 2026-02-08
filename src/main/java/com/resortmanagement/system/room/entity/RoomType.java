/*
TODO: RoomType.java
Purpose:
 - Category for rooms.
Fields:
 - id UUID
 - name String
 - baseRate BigDecimal
 - bedType String
 - areaSqFt int
 - maxOccupancy int
 - amenitiesSummary String
 - extends Auditable (optional)
Notes:
 - Pricing is via RatePlan; RoomType.baseRate as fallback.
File: room/entity/RoomType.java
*/
package com.resortmanagement.system.room.entity;

import java.util.UUID;

import com.resortmanagement.system.common.audit.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "room_types")
@Getter
@Setter
public class RoomType extends Auditable {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(name = "base_rate")
    private Double baseRate;

    @Column(name = "bed_type")
    private String bedType;

    @Column(name = "area_sq_ft")
    private Integer areaSqFt;

    @Column(name = "amenities_summary")
    private String amenitiesSummary;
}


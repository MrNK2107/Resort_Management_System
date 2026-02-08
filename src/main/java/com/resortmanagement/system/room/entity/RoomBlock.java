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

import java.time.LocalDateTime;
import java.util.UUID;

import com.resortmanagement.system.common.audit.AuditableSoftDeletable;
import com.resortmanagement.system.room.enums.BlockStatus;

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
@Table(name = "room_blocks")
@Getter
@Setter
public class RoomBlock extends AuditableSoftDeletable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "maintenance_request_id")
    private UUID maintenanceRequestId;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    private String reason;

    @Enumerated(EnumType.STRING)
    private BlockStatus status;

    @Column(name = "room_id", nullable = false)
    private UUID roomId;
}

package com.resortmanagement.system.room.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.resortmanagement.system.common.audit.AuditableSoftDeletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "room_types")
@Getter
@Setter
public class RoomType extends AuditableSoftDeletable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "base_rate")
    private Double baseRate;

    @Column(name = "bed_type")
    private String bedType;

    @Column(name = "area_sq_ft")
    private Integer areaSqFt;

    @Column(name = "amenities_summary")
    private String amenitiesSummary;

    @Column(name = "max_occupancy")
    private Integer maxOccupancy;

    @OneToMany(mappedBy = "roomType", fetch = FetchType.LAZY)
    private List<Room> rooms = new ArrayList<>();
}

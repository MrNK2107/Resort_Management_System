package com.resortmanagement.system.fnb.entity;

import com.resortmanagement.system.common.audit.AuditableSoftDeletable;
import com.resortmanagement.system.common.enums.ActivityEventStatus;
import com.resortmanagement.system.hr.entity.Employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "activity_events")
public class ActivityEvent extends AuditableSoftDeletable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Instant startTime;

    @Column(nullable = false)
    private Instant endTime;

    @Column(nullable = false)
    private int capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_item_id", nullable = false)
    private Employee instructorId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActivityEventStatus status;

}

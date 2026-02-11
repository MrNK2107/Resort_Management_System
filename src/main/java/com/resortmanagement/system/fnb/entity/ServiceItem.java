package com.resortmanagement.system.fnb.entity;

import com.resortmanagement.system.common.audit.AuditableSoftDeletable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "service_items")
@Getter
@Setter
public class ServiceItem extends AuditableSoftDeletable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    /**
     * Duration in minutes (e.g., spa = 60 mins)
     */
    @Column(name = "duration_mins")
    private Integer durationMins;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal basePrice;

    /**
     * Category like SPA, LAUNDRY, SHUTTLE
     * Kept as String to avoid premature enum coupling
     */
}
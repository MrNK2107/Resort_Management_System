package com.resortmanagement.system.fnb.dto.response;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import com.resortmanagement.system.common.enums.ActivityEventStatus;

// import lombok.Data;

public class ActivityEventResponse {
    private UUID id;
    private String title;
    private String description;
    private Instant startTime;
    private Instant endTime;
    private int capacity;
    private UUID instructorId;
    private BigDecimal price;
    private ActivityEventStatus status;

    // Manual Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public UUID getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(UUID instructorId) {
        this.instructorId = instructorId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ActivityEventStatus getStatus() {
        return status;
    }

    public void setStatus(ActivityEventStatus status) {
        this.status = status;
    }
}

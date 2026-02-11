package com.resortmanagement.system.fnb.dto.response;

import java.util.UUID;

// import lombok.Data;

public class MenuResponse {
    private UUID id;
    private String name;
    private String description;

    // Manual Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

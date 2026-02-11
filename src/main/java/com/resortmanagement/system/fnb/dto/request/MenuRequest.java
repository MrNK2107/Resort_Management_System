package com.resortmanagement.system.fnb.dto.request;

import jakarta.validation.constraints.NotBlank;

// import lombok.Data;

public class MenuRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    // Manual Getters and Setters

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

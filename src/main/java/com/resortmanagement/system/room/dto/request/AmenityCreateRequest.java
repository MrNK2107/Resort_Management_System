package com.resortmanagement.system.room.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmenityCreateRequest {
    @NotBlank
    private String name;

    private String description;

    private String category;
}

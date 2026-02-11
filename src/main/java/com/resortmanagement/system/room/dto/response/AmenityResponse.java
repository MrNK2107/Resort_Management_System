package com.resortmanagement.system.room.dto.response;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmenityResponse {
    private UUID id;
    private String name;
    private String description;
    private String category;
}

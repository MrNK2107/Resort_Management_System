package com.resortmanagement.system.room.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmenityUpdateRequest {

    private String name;
    private String description;
    private String category;
}

package com.resortmanagement.system.room.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomTypeUpdateRequest {

    private String name;

    private Double baseRate;

    private String bedType;

    private Integer areaSqFt;

    private Integer maxOccupancy;

    private String amenitiesSummary;
}

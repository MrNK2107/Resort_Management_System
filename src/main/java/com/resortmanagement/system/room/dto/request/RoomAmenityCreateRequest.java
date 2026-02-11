package com.resortmanagement.system.room.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomAmenityCreateRequest {

    @NotNull
    private UUID roomId;

    @NotNull
    private UUID amenityId;

    private Boolean complimentary; // optional
}

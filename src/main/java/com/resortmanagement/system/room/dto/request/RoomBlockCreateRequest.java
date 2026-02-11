package com.resortmanagement.system.room.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

import com.resortmanagement.system.room.enums.BlockStatus;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomBlockCreateRequest {

    @NotNull(message = "Room ID is required")
    private UUID roomId;

    private UUID maintenanceRequestId; // optional, link if from MaintenanceRequest

    @NotNull(message = "Start date is required")
    private LocalDateTime startDate;

    @NotNull(message = "End date is required")
    private LocalDateTime endDate;

    @Size(max = 250)
    private String reason;

    private BlockStatus status; // optional, default can be CREATED or ACTIVE
}

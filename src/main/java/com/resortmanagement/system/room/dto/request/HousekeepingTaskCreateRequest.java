package com.resortmanagement.system.room.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

import com.resortmanagement.system.room.enums.HousekeepingPriority;
import com.resortmanagement.system.room.enums.HousekeepingStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HousekeepingTaskCreateRequest {

    @NotNull
    private UUID roomId;

    private UUID staffId;

    @NotNull
    private LocalDateTime scheduledAt;

    @NotNull
    private HousekeepingPriority priority;

    @NotNull
    private HousekeepingStatus status;

    private String notes;
}

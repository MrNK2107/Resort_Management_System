package com.resortmanagement.system.room.dto.request;

import java.time.LocalDateTime;

import com.resortmanagement.system.room.enums.BlockStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomBlockUpdateRequest {

    private LocalDateTime startDate;   // optional
    private LocalDateTime endDate;     // optional
    private String reason;             // optional
    private BlockStatus status;        // optional
}

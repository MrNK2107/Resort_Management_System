package com.resortmanagement.system.hr.dto.shiftschedule;

import java.time.Instant;
import java.util.UUID;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShiftScheduleRequest {
    private UUID employeeId;
    private Instant startTime;
    private Instant endTime;
    private String position;
    private String location;
}

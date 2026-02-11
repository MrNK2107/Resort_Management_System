package com.resortmanagement.system.support.dto.request;

import java.util.UUID;

import com.resortmanagement.system.support.enums.TicketPriority;
import com.resortmanagement.system.support.enums.TicketStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelpTicketUpdateRequest {

    private TicketPriority priority;

    private TicketStatus status;

    private UUID assignedTo;
}

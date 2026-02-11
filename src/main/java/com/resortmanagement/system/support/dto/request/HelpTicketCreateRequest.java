package com.resortmanagement.system.support.dto.request;

import java.util.UUID;

import com.resortmanagement.system.support.enums.TicketPriority;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelpTicketCreateRequest {

    private UUID guestId;
    private UUID reservationId;

    private String category;
    private String description;

    private TicketPriority priority;
}

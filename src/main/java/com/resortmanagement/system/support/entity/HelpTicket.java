/*
TODO: HelpTicket.java
Purpose:
 - Guest request / helpdesk ticket entity.
Fields:
 - id UUID
 - guestId UUID
 - reservationId UUID
 - category String
 - description String
 - priority String
 - status String (OPEN, ASSIGNED, RESOLVED, CLOSED)
 - assignedTo UUID
 - createdAt via Auditable
Notes:
 - Ticket lifecycle managed via HelpTicketService; write AuditLog entries on important state changes.
File: support/entity/HelpTicket.java
*/
package com.resortmanagement.system.support.entity;

import java.time.LocalDateTime;
import java.util.UUID;


import com.resortmanagement.system.common.audit.AuditableSoftDeletable;
import com.resortmanagement.system.support.enums.TicketPriority;
import com.resortmanagement.system.support.enums.TicketStatus;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "help_tickets")
@Getter
@Setter
public class HelpTicket extends AuditableSoftDeletable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @Column(name = "guest_id", nullable = false)
    private UUID guestId;

    @Column(name = "ticket_id")
    private String ticketId;

    private String category;

    private String description;

    @Enumerated(EnumType.STRING)
    private TicketPriority priority;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Column(name = "assigned_to")
    private UUID assignedTo;

    @Column(name = "reservation_id")
    private UUID reservationId;

    @Column(name = "resolved_at")
    private LocalDateTime resolvedAt;
}

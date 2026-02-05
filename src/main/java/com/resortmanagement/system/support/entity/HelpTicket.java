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

public class HelpTicket {
    // TODO: fields, constructors, getters, setters
}
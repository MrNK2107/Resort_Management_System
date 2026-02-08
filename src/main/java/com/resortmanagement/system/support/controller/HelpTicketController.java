/*
TODO: HelpTicketController.java
Purpose:
 - Internal helpdesk or guest requests management.
Endpoints:
 - POST /api/v1/help-tickets -> create ticket
 - GET /api/v1/help-tickets/{id}
 - POST /api/v1/help-tickets/{id}/assign
Responsibilities:
 - Tickets link to reservation and guest; triage and assign to staff.
 - Service handles priority and SLA logic, sends notifications.
File: support/controller/HelpTicketController.java
*/
package com.resortmanagement.system.support.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resortmanagement.system.support.entity.HelpTicket;
import com.resortmanagement.system.support.service.HelpTicketService;

@RestController
@RequestMapping("/api/help-tickets")
public class HelpTicketController {

    private final HelpTicketService service;

    public HelpTicketController(HelpTicketService service) {
        this.service = service;
    }

    @PostMapping
    public HelpTicket create(@RequestBody HelpTicket ticket) {
        return service.create(ticket);
    }

    @GetMapping
    public List<HelpTicket> open() {
        return service.getOpenTickets();
    }

    @DeleteMapping("/{id}")
    public void close(@PathVariable UUID id) {
        service.close(id);
    }
}


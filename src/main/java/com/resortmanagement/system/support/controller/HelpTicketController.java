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

import com.resortmanagement.system.support.dto.request.HelpTicketCreateRequest;
import com.resortmanagement.system.support.dto.response.HelpTicketResponse;
import com.resortmanagement.system.support.service.HelpTicketService;

@RestController
@RequestMapping("/api/support/tickets")
public class HelpTicketController {

    private final HelpTicketService service;

    public HelpTicketController(HelpTicketService service) {
        this.service = service;
    }

    @PostMapping
    public HelpTicketResponse create(@RequestBody HelpTicketCreateRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<HelpTicketResponse> all() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void close(@PathVariable UUID id) {
        service.delete(id);
    }
}

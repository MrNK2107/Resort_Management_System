package com.resortmanagement.system.support.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.support.entity.HelpTicket;
import com.resortmanagement.system.support.repository.HelpTicketRepository;

@Service
public class HelpTicketService {

    private final HelpTicketRepository repository;

    public HelpTicketService(HelpTicketRepository repository) {
        this.repository = repository;
    }

    public HelpTicket create(HelpTicket ticket) {
        return repository.save(ticket);
    }

    public List<HelpTicket> getOpenTickets() {
        return repository.findByDeletedFalse();
    }

    public void close(UUID id) {
        repository.softDeleteById(id, Instant.now());
    }
}


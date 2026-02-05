package com.resortmanagement.system.support.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.resortmanagement.system.support.repository.HelpTicketRepository;
import com.resortmanagement.system.support.entity.HelpTicket;

@Service
public class HelpTicketService {

    private final HelpTicketRepository repository;

    public HelpTicketService(HelpTicketRepository repository) {
        this.repository = repository;
    }

    public List<HelpTicket> findAll() {
        // TODO: add pagination and filtering
        return repository.findAll();
    }

    public Optional<HelpTicket> findById(Long id) {
        // TODO: add caching and error handling
        return repository.findById(id);
    }

    public HelpTicket save(HelpTicket entity) {
        // TODO: add validation and business rules
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        // TODO: add soft delete if required
        repository.deleteById(id);
    }
}

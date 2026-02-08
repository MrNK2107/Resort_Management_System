package com.resortmanagement.system.support.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.support.entity.Communication;
import com.resortmanagement.system.support.repository.CommunicationRepository;

@Service
public class CommunicationService {

    private final CommunicationRepository repository;

    public CommunicationService(CommunicationRepository repository) {
        this.repository = repository;
    }

    public Communication create(Communication communication) {
        return repository.save(communication);
    }

    public List<Communication> getAll() {
        return repository.findByDeletedFalse();
    }
}


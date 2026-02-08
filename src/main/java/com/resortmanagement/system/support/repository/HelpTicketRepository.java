package com.resortmanagement.system.support.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.resortmanagement.system.common.repository.SoftDeleteRepository;
import com.resortmanagement.system.support.entity.HelpTicket;

@Repository
public interface HelpTicketRepository
        extends SoftDeleteRepository<HelpTicket, UUID> {
}


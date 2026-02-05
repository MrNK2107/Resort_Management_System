/**
 * TODO: File-level design notes
 *
 * WHAT: Describe the purpose of this class/interface (e.g., manages Folios, groups invoices and charges per guest/stay).
 * WHY: Belongs to the billing module; keep cross-cutting concerns (audit, security) minimal here.
 * HOW:
 *  - Business logic belongs in the service layer; controllers orchestrate and map DTOs.
 *  - Use DTOs for API boundaries and mapping (MapStruct or manual).
 *  - Annotate mutating service methods with @Transactional.
 *  - Use optimistic locking (@Version) on entities that require concurrency control.
 * Data owned: primary entity related to this file (Invoice/Payment/Refund/Folio/AccountLedger).
 * Relationships: list repositories and related entities; avoid tight coupling to other modules.
 * Security: Check permissions (e.g., ROLE_BILLING, ROLE_FINANCE) at the service/controller boundary.
 * Audit: Implement/business events and Auditable base where needed; log important state changes.
 * Forbidden responsibilities: Do not place complex persistence or orchestration logic in controllers; no direct external calls from repositories.
 *
 * Tests: Add unit tests for business rules and integration tests for repository interactions.
 */
package com.resortmanagement.system.billing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.billing.entity.Folio;
import com.resortmanagement.system.billing.repository.FolioRepository;

@Service
public class FolioService {

    private final FolioRepository repository;

    public FolioService(FolioRepository repository) {
        this.repository = repository;
    }

    public List<Folio> findAll() {
        // TODO: add pagination and filtering
        return this.repository.findAll();
    }

    public Optional<Folio> findById(Long id) {
        // TODO: add caching and error handling
        return this.repository.findById(id);
    }

    public Folio save(Folio folio) {
        // TODO: add validation and business rules
        return this.repository.save(folio);
    }

    public void deleteById(Long id) {
        // TODO: add soft delete if required
        this.repository.deleteById(id);
    }
}

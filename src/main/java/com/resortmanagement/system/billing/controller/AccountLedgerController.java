/**
TODO: AccountLedgerController.java
Purpose:
 - Expose REST endpoints for ledger queries and adjustments.
 - Controller should be thin: validate DTOs, call AccountLedgerService.

Endpoints (suggested):
 - GET /api/v1/billing/ledgers -> list ledgers (pageable)
 - GET /api/v1/billing/ledgers/{id} -> get ledger detail
 - POST /api/v1/billing/ledgers/adjust -> admin-only adjustment (body: ledgerId, amount, reason)

Responsibilities:
 - Use DTOs for input/output (AccountLedgerRequest, AccountLedgerResponse).
 - Validate user roles with @PreAuthorize (e.g., ROLE_FINANCE, ROLE_ADMIN).
 - Map exceptions to proper HTTP codes via global @ControllerAdvice.

Implementation notes:
 - Do NOT implement business logic here. Call AccountLedgerService.
 - Include simple request logging and correlation id (from header).
 - Return appropriate 201/200/404 statuses.

File: billing/controller/AccountLedgerController.java
*/
package com.resortmanagement.system.billing.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resortmanagement.system.billing.entity.AccountLedger;
import com.resortmanagement.system.billing.service.AccountLedgerService;

@RestController
@RequestMapping("/api/billing/accountledgers")
public class AccountLedgerController {

    private final AccountLedgerService accountLedgerService;

    public AccountLedgerController(AccountLedgerService accountLedgerService) {
        this.accountLedgerService = accountLedgerService;
    }

    @GetMapping
    public ResponseEntity<List<AccountLedger>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(accountLedgerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountLedger> getById(@PathVariable Long id) {
        return accountLedgerService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AccountLedger> create(@RequestBody AccountLedger accountLedger) {
        // TODO: add validation
        return ResponseEntity.ok(accountLedgerService.save(accountLedger));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountLedger> update(@PathVariable Long id, @RequestBody AccountLedger accountLedger) {
        // TODO: implement update logic
        return ResponseEntity.ok(accountLedgerService.save(accountLedger));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accountLedgerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

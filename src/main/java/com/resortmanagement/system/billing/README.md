# Billing Domain

Purpose
- Handles all billing, invoicing, payments, refunds and account ledger responsibilities for the resort.
- Responsible for converting in-app charges (folios, orders, services) into financial documents (invoices), recording payments, and managing refunds and accounting ledger items.

Interactions with other domains
- Booking: consumes folios and reservation references to produce folios and invoices.
- FNB: receives order/folio items to be attached to folios for guest billing.
- Reporting: emits financial audit logs and report data.
- Inventory: may receive chargebacks for inventory-linked costs.
- Common (Guest): references guest identifiers and loyalty accounts.

Key artifacts
- Entities:
  - `Folio.java` - a billing bucket per reservation
  - `Invoice.java` - generated financial document
  - `Payment.java` - payment attempt/result
  - `Refund.java` - refund records
  - `AccountLedger.java` - ledger entries
- Controllers:
  - `FolioController.java`, `InvoiceController.java`, `PaymentController.java`, `RefundController.java`, `AccountLedgerController.java`
- Services:
  - `FolioService.java`, `InvoiceService.java`, `PaymentService.java`, `RefundService.java`, `AccountLedgerService.java`
- Repositories:
  - `FolioRepository.java`, `InvoiceRepository.java`, `PaymentRepository.java`, `RefundRepository.java`, `AccountLedgerRepository.java`

Transaction boundaries
- Use service-layer transactions for each mutating operation.
- Critical flows: invoice creation (factory), payment capture (transactional with idempotency), refund (transactional with external PSP reconciliation), ledger posting (transactional and eventual consistency for balancing batch jobs).
- Never combine long-running external calls (e.g., PSP network calls) inside a single DB transaction — orchestrate using outboxes or event-driven patterns.

Auditing, soft delete, concurrency
- **Auditing**: Audit important state changes in an `AuditLog` and entities that are business-critical should extend `Auditable`.
- **Soft delete**: Do not physically delete financial records (invoices, payments, refunds); use status flags to mark cancellations.
- **Concurrency**: Use optimistic locking (`@Version`) for invoice/follow-up updates and idempotency tokens for payment operations to prevent double charges.

Security roles
- Finance/Admin: create/adjust invoices, refunds
- Frontdesk: create folios and charges
- System: internal services and batch jobs (service accounts)
- Logging & RBAC: all endpoints should be protected and audited

Design patterns used
- Factory: `InvoiceFactory` and `PaymentFactory` for constructing domain objects
- Strategy: Payment provider integrations (different PSPs)
- Builder: Complex invoice/folio building
- Template Method: Reconciliation reports

Typical workflows
- Create folio from reservation -> add line items -> close folio -> create invoice via InvoiceService -> capture payment via PaymentService -> post to AccountLedger -> generate reporting entries.
- Refund flow: create refund request -> validate idempotency and permissions -> issue refund via PSP -> record refund and update ledger.

Notes
- Follow project conventions in `COMMON TEMPLATES` for audit/logging and transactional patterns.
- Keep controllers thin and use DTOs for all external payloads.

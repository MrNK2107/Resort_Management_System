/**
TODO: Invoice.java
Purpose:
 - Persisted financial document generated from folio charges.
Fields:
 - id: UUID
 - folioId: UUID (ManyToOne -> Folio)
 - reservationId: UUID (optional)
 - guestId: UUID
 - issueDate: Instant
 - dueDate: Instant
 - totalAmount: BigDecimal
 - taxAmount: BigDecimal
 - status enum (DRAFT, ISSUED, PAID, PARTIALLY_PAID, REFUNDED, CANCELLED)
 - currency String
 - extends Auditable (must track who issued)
 - store request/response snapshot JSON if needed (for dispute)
Notes:
 - Immutable once ISSUED except for credit/refund operations stored separately.
 - Use InvoiceService to compute totals; never compute in controllers.

File: billing/entity/Invoice.java
 */
package com.resortmanagement.system.billing.entity;

public class Invoice {
    // TODO: fields, constructors, getters, setters
}
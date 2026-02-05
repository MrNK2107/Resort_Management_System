/**
TODO: Payment.java
Purpose:
 - Records payment attempts and results for invoices.
Fields:
 - id: UUID
 - invoiceId: UUID (ManyToOne -> Invoice)
 - reservationId: UUID (nullable)
 - guestId: UUID
 - amount: BigDecimal
 - method: enum (CARD, UPI, CASH, WALLET)
 - transactionRef: String (PSP reference)
 - status: PaymentStatus (PENDING, SUCCESS, FAILED, REFUNDED)
 - providerResponse: JSON/string for PSP raw response
 - processedAt: Instant
 - extends Auditable (important for PCI/compliance trace)
Notes:
 - Do NOT store card PAN/CVV. Use PSP tokenization.
 - Payment creation and invoice update should be handled in a single transactional service method with idempotency.

File: billing/entity/Payment.java
 */
package com.resortmanagement.system.billing.entity;

public class Payment {
    // TODO: fields, constructors, getters, setters
}
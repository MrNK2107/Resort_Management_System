/**
TODO: Refund.java
Purpose:
 - Persist refund operations and statuses.
Fields:
 - id: UUID
 - paymentId: UUID (FK to Payment)
 - invoiceId: UUID (optional)
 - amount: BigDecimal
 - reason: String
 - processedBy: String (auditable but keep as field for quick reporting)
 - processedAt: Instant
 - status: enum (REQUESTED, PROCESSING, SUCCESS, FAILED)
 - providerRefundRef: String
 - extends Auditable
Notes:
 - All refund flows must be idempotent and logged in AuditLog with reason.
 - Do not perform external PSP ops in the controller; do it in RefundService with retries and idempotency.
File: billing/entity/Refund.java
 */
package com.resortmanagement.system.billing.entity;

public class Refund {
    // TODO: fields, constructors, getters, setters
}
/**
TODO: Folio.java
Purpose:
 - Billing bucket entity; multiple folios per reservation allow split billing.
Fields & annotations:
 - @Entity @Table("folio")
 - id: UUID PK
 - reservationId: UUID @ManyToOne -> Reservation (optional lazy)
 - name: String (e.g., "Main Folio", "Incidentals - Guest A")
 - bookingGuestId: UUID nullable (if folio is assigned to a specific BookingGuest)
 - status enum (OPEN/CLOSED)
 - createdAt/updatedAt handled by Auditable -> extend Auditable
 - totalAmount computed or stored (BigDecimal) - prefer compute in query or maintain by service
 - soft-delete not required; closing is a state change
Behavior:
 - No heavy logic inside entity.
 - Provide equals/hashCode only on id.

File: billing/entity/Folio.java
 */
package com.resortmanagement.system.billing.entity;

public class Folio {
    // TODO: fields, constructors, getters, setters
}
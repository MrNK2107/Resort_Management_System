# Booking Domain

Purpose
- Manages reservation lifecycle: creation, modification, confirmation, check-in, check-out and cancellations.
- Responsible for availability checks, rates snapshotting, guest assignment and scheduling of reservation-level services.

Interactions with other domains
- Pricing: uses RatePlan and RateHistory to price reservations.
- Room: reserves rooms / room types and manages room availability.
- Billing: attaches folio and billing items to reservations.
- FNB: integrates with reservations for dining reservations and charge posting.
- Reporting: emits booking events and occupancy reports.

Key artifacts
- Entities:
  - `Reservation.java`, `ReservationAddOn.java`, `ReservationDailyRate.java`, `ReservationServiceBooking.java`, `BookingGuest.java`
- Controllers:
  - `ReservationController.java`, `ReservationAddOnController.java`, `ReservationDailyRateController.java`, `ReservationServiceBookingController.java`, `BookingGuestController.java`
- Services:
  - `ReservationService.java`, `ReservationAddOnService.java`, `ReservationDailyRateService.java`, `ReservationServiceBookingService.java`, `BookingGuestService.java`
- Repositories:
  - `ReservationRepository.java`, `ReservationAddOnRepository.java`, `ReservationDailyRateRepository.java`, `ReservationServiceBookingRepository.java`, `BookingGuestRepository.java`

Transaction boundaries
- Each booking create/update/cancel operation should be transactional at the service layer.
- Availability checks should be implemented with careful locking or atomic checks (optimistic locking, DB locks, or distributed locks) to avoid overbooking.
- Pricing and folio creation should be decoupled where external calls are involved.

Auditing, soft delete, concurrency
- **Auditing**: Reservations, daily rates, and critical booking changes should extend `Auditable` to keep who/when.
- **Soft delete**: Use soft-delete for reservations to preserve historical/financial integrity.
- **Concurrency**: Use `@Version` and explicit checks for availability; protect cross-property bookings with distributed locking.

Security roles
- Frontdesk: create/modify reservations
- Reservations Manager: cancel and manage overbooked scenarios
- Read-only: reporting and analytics

Design patterns used
- Factory: `ReservationFactory` (to enforce invariants and create associated daily rates)
- Builder: building complex Reservation DTOs
- Strategy: pricing strategies for promotional and seasonal adjustments

Typical workflows
- Search availability -> build reservation request -> ReservationService validates constraints and uses RatePlan/RateHistory -> create Reservation and ReservationDailyRate snapshots -> attach folios and notify downstream systems.

Notes
- Keep controllers thin and use DTOs; validation with `@Valid`.
- Avoid long transactions with external calls; use events or outbox for integration steps.

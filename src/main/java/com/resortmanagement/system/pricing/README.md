# Pricing Domain

Purpose
- Defines rate plans, seasonal rate history and price overrides used to compute reservation nightly prices.

Interactions with other domains
- Booking: pricing rules are applied when creating reservation daily rates.
- Marketing: promotions and packages modify the final price.
- Reporting/Billing: pricing snapshots are stored and used for invoicing.

Key artifacts
- Entities: `RatePlan.java`, `RateHistory.java`
- Controllers: `RatePlanController.java`, `RateHistoryController.java`
- Services: `RatePlanService.java`, `RateHistoryService.java`
- Repositories: `RatePlanRepository.java`, `RateHistoryRepository.java`

Transaction boundaries
- Rate plan updates are transactional; rate history inserts should validate non-overlapping ranges in a single transaction.

Auditing, soft delete, concurrency
- **Auditing**: changes to RatePlan/RateHistory must be auditable.
- **Soft delete**: archive rate plans instead of deleting to preserve historical pricing.
- **Concurrency**: ensure non-overlapping validation under transaction isolation or DB constraints.

Security roles
- Revenue Manager: modify rate plans and histories
- Pricing Analyst: read-only and schedule changes

Design patterns used
- Strategy: pricing engines and promotion composition
- Builder: assembling final pricing packages

Typical workflows
- Create/modify RatePlan -> create RateHistory entries -> Booking requests compute ReservationDailyRate using composed pricing rules.

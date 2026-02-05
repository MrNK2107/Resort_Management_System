# Marketing Domain

Purpose
- Manages promotions, packages, and loyalty members to drive guest engagement and pricing adjustments.

Interactions with other domains
- Pricing: promotions and pricing rules integrate with RatePlan/RateHistory.
- Booking: promotions apply during reservation creation; packages expand into reservations.
- Billing: promotions may create discounts on folios/invoices.
- Reporting: track promotion usage and loyalty metrics.

Key artifacts
- Entities: `Promotion.java`, `Package.java`, `PackageItem.java`, `LoyaltyMember.java`
- Controllers: `PromotionController.java`, `PackageController.java`, `PackageItemController.java`, `LoyaltyMemberController.java`
- Services: `PromotionService.java`, `PackageService.java`, `PackageItemService.java`, `LoyaltyMemberService.java`
- Repositories: `PromotionRepository.java`, `PackageRepository.java`, `PackageItemRepository.java`, `LoyaltyMemberRepository.java`

Transaction boundaries
- Promotion application should be idempotent and validated within booking flow transactions.

Auditing, soft delete, concurrency
- **Auditing**: record who issued promotions and loyalty changes.
- **Soft delete**: allow promotions to be archived; loyalty records should be retained for history.
- **Concurrency**: handle high-request volume for promo codes with safe counters.

Security roles
- Marketing Admin: create/expire promotions and packages
- Finance: view promotion financial impact

Design patterns used
- Strategy: promotion application rules
- Builder: package composition

Typical workflows
- Create promotion -> schedule active period -> promotionService.validateAndApply(promoCode, reservation) -> adjust price or throw PromotionInvalidException.

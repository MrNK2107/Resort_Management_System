# Food & Beverage (FNB) Domain

Purpose
- Manages menus, orders, POS-style transactions, activity events (guest experiences), and recipe/ingredient mappings.
- Provides services for order creation, confirmation, inventory reservations, and billing attachments.

Interactions with other domains
- Inventory: deducts inventory when orders are confirmed; uses MenuItemIngredient mapping.
- Billing: creates folio items or direct invoice lines for orders and services.
- Booking: links orders or activity registrations to reservations and guests.
- Reporting: sends sales data and usage metrics.

Key artifacts
- Entities:
  - `Menu.java`, `MenuItem.java`, `MenuItemIngredient.java`, `Order.java`, `OrderItem.java`, `ActivityEvent.java`, `ServiceItem.java`
- Controllers:
  - `MenuController.java`, `MenuItemController.java`, `MenuItemIngredientController.java`, `OrderController.java`, `OrderItemController.java`, `ActivityEventController.java`
- Services:
  - `MenuService.java`, `MenuItemService.java`, `MenuItemIngredientService.java`, `OrderService.java`, `OrderItemService.java`, `ActivityEventService.java`
- Repositories:
  - `OrderRepository.java`, `OrderItemRepository.java`, `MenuRepository.java`, `MenuItemRepository.java`, `ServiceItemRepository.java`

Transaction boundaries
- Order confirmation, inventory deduction and invoice posting should be transactional where possible (atomic inventory update + order status update). Prefer short transactions with compensating actions for external calls.

Auditing, soft delete, concurrency
- **Auditing**: Orders and menus should extend `Auditable` to track changes.
- **Soft delete**: Menus and menu items can be soft-deleted; orders and order items should be immutable once confirmed.
- **Concurrency**: Use optimistic locking for inventory updates and idempotency for order confirmation to prevent double deductions.

Security roles
- POS Operator: create and confirm orders
- Kitchen: view and update order status
- Manager/Finance: issue refunds, manual adjustments

Design patterns used
- Strategy: pricing and promotions per item
- Template Method / Adapter: external POS or payment providers
- Builder: complex order creation

Typical workflows
- Menu maintenance -> menu item availability -> guest places order -> OrderService validates availability -> upon confirm: deduct inventory, attach folio line and notify kitchen.

Notes
- Keep controllers thin, use DTOs for payloads and `@Valid` for input.
- Use service-layer orchestration for cross-domain flows and audit critical state changes.

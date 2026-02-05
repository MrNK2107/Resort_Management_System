# Inventory Domain

Purpose
- Tracks inventory items, transactions, suppliers and purchase orders.
- Ensures correct stock levels and provides APIs to adjust, receive, and audit inventory.

Interactions with other domains
- FNB: consumes inventory when orders are confirmed (through MenuItemIngredient mapping).
- Purchasing/Procurement: purchase orders create inventory receipts.
- Reporting: stock levels and inventory transaction reports.
- Billing: cost allocation to folios/ledgers when needed.

Key artifacts
- Entities:
  - `InventoryItem.java`, `InventoryTransaction.java`, `PurchaseOrder.java`, `PurchaseOrderLine.java`, `Supplier.java`
- Controllers:
  - `InventoryItemController.java`, `InventoryTransactionController.java`, `PurchaseOrderController.java`, `PurchaseOrderLineController.java`, `SupplierController.java`
- Services:
  - `InventoryItemService.java`, `InventoryTransactionService.java`, `PurchaseOrderService.java`, `PurchaseOrderLineService.java`, `SupplierService.java`
- Repositories:
  - `InventoryItemRepository.java`, `InventoryTransactionRepository.java`, `PurchaseOrderRepository.java`, `PurchaseOrderLineRepository.java`, `SupplierRepository.java`

Transaction boundaries
- Inventory adjustments and receipt flows should be transactional (update quantity + insert transaction row).
- Use compensating transactions or event-based approaches when external supplier confirmations are required.

Auditing, soft delete, concurrency
- **Auditing**: Inventory transactions must be auditable for traceability.
- **Soft delete**: Inventory items may be soft deleted; transactions should be immutable.
- **Concurrency**: Use optimistic locking (`@Version`) on `InventoryItem` to prevent lost updates; for high-concurrency operations consider DB-level counters or stored procedures.

Security roles
- Inventory Manager: manage supplier/catalog and adjust stock
- Warehouse: perform receipts and manual adjustments
- Auditor: read-only access to transaction logs

Design patterns used
- Template Method / Factory for receiving PO lines and converting to inventory transactions
- Strategy for alternate stock allocation rules

Typical workflows
- Create purchase order -> receive items -> create inventory transactions (IN) -> update InventoryItem.quantityOnHand -> generate reconciliation reports.

Notes
- Ensure critical inventory operations are idempotent and tested for concurrency.

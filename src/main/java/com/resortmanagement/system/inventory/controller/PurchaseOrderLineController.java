/*
TODO: PurchaseOrderLineController.java
Purpose:
 - Manage purchase order line items (PO line entries linked to PurchaseOrder and InventoryItem).
Endpoints:
 - GET /api/v1/purchaseorderlines -> list lines (pageable)
 - GET /api/v1/purchaseorderlines/{id}
 - POST /api/v1/purchaseorderlines -> add line to PO
 - PUT /api/v1/purchaseorderlines/{id} -> update line
 - DELETE /api/v1/purchaseorderlines/{id}
Responsibilities:
 - Validate inventory item existence and unit consistency.
 - Use PurchaseOrderLineService for transactional updates; adjustments should be applied at PO receive time.
 - Keep controllers thin and use DTOs for input/output.
File: inventory/controller/PurchaseOrderLineController.java
*/
package com.resortmanagement.system.inventory.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.resortmanagement.system.inventory.service.PurchaseOrderLineService;
import com.resortmanagement.system.inventory.entity.PurchaseOrderLine;

@RestController
@RequestMapping("/api/inventory/purchaseorderlines")
public class PurchaseOrderLineController {

    private final PurchaseOrderLineService service;

    public PurchaseOrderLineController(PurchaseOrderLineService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrderLine>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderLine> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PurchaseOrderLine> create(@RequestBody PurchaseOrderLine entity) {
        // TODO: add validation
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderLine> update(@PathVariable Long id, @RequestBody PurchaseOrderLine entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

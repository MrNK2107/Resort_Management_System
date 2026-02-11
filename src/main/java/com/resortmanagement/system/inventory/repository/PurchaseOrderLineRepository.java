package com.resortmanagement.system.inventory.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.inventory.entity.PurchaseOrderLine;

@Repository
public interface PurchaseOrderLineRepository
        extends JpaRepository<PurchaseOrderLine, UUID> {

    /**
     * Fetch all lines for a purchase order
     */
    List<PurchaseOrderLine> findByPurchaseOrderId(UUID purchaseOrderId);

    Optional<PurchaseOrderLine> findById(Long id);

    void deleteById(Long id);
}

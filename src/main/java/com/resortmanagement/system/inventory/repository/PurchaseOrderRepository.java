package com.resortmanagement.system.inventory.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.inventory.entity.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository
        extends JpaRepository<PurchaseOrder, UUID> {

    Optional<PurchaseOrder> findByPoNumber(String poNumber);

    List<PurchaseOrder> findByStatus(PurchaseOrder status);

    List<PurchaseOrder> findBySupplierId(UUID supplierId);
}

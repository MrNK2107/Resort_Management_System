package com.resortmanagement.system.inventory.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.inventory.entity.InventoryItem;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, UUID> {

    /**
     * Fetch items that are below reorder point
     */
    @Query("""
        select i 
        from InventoryItem i 
        where i.quantityOnHand <= i.reorderPoint
    """)
    List<InventoryItem> findLowStockItems();

    /**
     * Atomic decrement of inventory quantity
     * Returns number of rows updated (0 = insufficient stock)
     */
    @Modifying
    @Query("""
        update InventoryItem i
        set i.quantityOnHand = i.quantityOnHand - :qty
        where i.id = :itemId
          and i.quantityOnHand >= :qty
    """)
    int consumeStock(
            @Param("itemId") UUID itemId,
            @Param("qty") BigDecimal qty
    );

    /**
     * Atomic increment of inventory quantity
     */
    @Modifying
    @Query("""
        update InventoryItem i
        set i.quantityOnHand = i.quantityOnHand + :qty
        where i.id = :itemId
    """)
    int addStock(
            @Param("itemId") UUID itemId,
            @Param("qty") BigDecimal qty
    );
}


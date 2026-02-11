package com.resortmanagement.system.fnb.entity;

import com.resortmanagement.system.common.audit.Auditable;
import com.resortmanagement.system.inventory.entity.InventoryItem;
import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "menu_item_ingredients")
public class MenuItemIngredient extends Auditable {

    @Id
    @GeneratedValue
    private UUID id;

    /**
     * Many ingredients belong to one MenuItem
     * FK: menu_item_id
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;

    /**
     * Inventory item used in this recipe line
     * FK: inventory_item_id
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_item_id", nullable = false)
    private InventoryItem inventoryItem;

    /**
     * Quantity required per ONE menu item
     * Stored in inventoryItem.baseUnit
     */
    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal quantityRequired;

    /**
     * Human-readable unit (e.g., "grams", "ml", "pieces")
     * Conversions handled at write-time
     */
    @Column(nullable = false)
    private String unit;

    // Manual Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public BigDecimal getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(BigDecimal quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

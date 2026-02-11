package com.resortmanagement.system.fnb.entity;

import com.resortmanagement.system.common.audit.AuditableSoftDeletable;
import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "menu_items")
public class MenuItem extends AuditableSoftDeletable {

    @Id
    @GeneratedValue
    private UUID id;

    /**
     * Many MenuItems belong to one Menu
     * FK: menu_id
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private boolean isAvailable = true;

    /**
     * MenuItem → MenuItemIngredient
     * Inventory linkage happens via this mapping
     */
    @OneToMany(
            mappedBy = "menuItem",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Set<MenuItemIngredient> ingredients = new HashSet<>();

    // Manual Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Set<MenuItemIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<MenuItemIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}

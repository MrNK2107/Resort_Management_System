/*
TODO: FNB repository & service guidelines
Repositories:
 - extend JpaRepository
 - provide queries for active items, menu lookups

Services:
 - OrderService.confirmOrder must:
    * be @Transactional
    * check ingredient availability
    * perform atomic decrement (UPDATE ... WHERE quantity_on_hand >= :qty)
    * insert InventoryTransaction rows with sourceType=ORDER and sourceId=order.id
 - MenuItemService to manage menu items and update recipe.

File: fnb/repository/<File>.java, fnb/service/<File>.java
*/
package com.resortmanagement.system.fnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.fnb.entity.ActivityEvent;

@Repository
public interface ActivityEventRepository extends JpaRepository<ActivityEvent, Long> {
    // TODO: add custom queries if needed
}

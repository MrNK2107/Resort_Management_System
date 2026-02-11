package com.resortmanagement.system.fnb.repository;

import com.resortmanagement.system.fnb.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, UUID> {

    @Query("select m from MenuItem m where m.deletedAt is null")
    List<MenuItem> findAllActive();

    @Modifying
    @Query("update MenuItem m set m.deletedAt = CURRENT_TIMESTAMP where m.id = :id")
    void softDeleteById(@Param("id") UUID id);
}

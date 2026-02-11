package com.resortmanagement.system.fnb.repository;

import com.resortmanagement.system.fnb.entity.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ServiceItemRepository extends JpaRepository<ServiceItem, UUID> {

    /**
     * Fetch only active (not soft-deleted) service items
     */
    @Query("select s from ServiceItem s where s.deletedAt is null")
    List<ServiceItem> findAllActive();

    /**
     * Soft delete service item
     */
    @Modifying
    @Query("update ServiceItem s set s.deletedAt = CURRENT_TIMESTAMP where s.id = :id")
    void softDeleteById(@Param("id") UUID id);
}

package com.resortmanagement.system.fnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.fnb.entity.ServiceItem;

@Repository
public interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {
    // TODO: add custom queries if needed
}

package com.resortmanagement.system.marketing.repository;

import com.resortmanagement.system.common.repository.SoftDeleteRepository;
import com.resortmanagement.system.marketing.entity.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PromotionRepository extends SoftDeleteRepository<Promotion, UUID> {

    // Find by code
    Optional<Promotion> findByCode(String code);

    // Find by deleted status with pagination
    Page<Promotion> findByDeletedFalse(Pageable pageable);

    // Find by ID with soft delete check
    Optional<Promotion> findByIdAndDeletedFalse(UUID id);
}

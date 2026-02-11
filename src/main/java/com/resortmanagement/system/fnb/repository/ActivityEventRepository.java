package com.resortmanagement.system.fnb.repository;

import com.resortmanagement.system.fnb.entity.ActivityEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ActivityEventRepository extends JpaRepository<ActivityEvent, UUID> {

    void deleteAll(Long id);
    // Add custom queries later only if required

    Optional<ActivityEvent> findAllById(Long id);

    void softDeleteById(UUID id);
}

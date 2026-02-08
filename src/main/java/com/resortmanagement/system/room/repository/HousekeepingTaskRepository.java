package com.resortmanagement.system.room.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.resortmanagement.system.common.repository.SoftDeleteRepository;
import com.resortmanagement.system.room.entity.HousekeepingTask;

import com.resortmanagement.system.room.entity.HousekeepingTask;
@Repository
public interface HousekeepingTaskRepository extends SoftDeleteRepository<HousekeepingTask, UUID> {
    // TODO: add custom queries if needed
}

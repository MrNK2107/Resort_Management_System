package com.resortmanagement.system.support.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.support.entity.Communication;

@Repository
public interface CommunicationRepository extends JpaRepository<Communication, UUID> {

    List<Communication> findByDeletedFalse();
}


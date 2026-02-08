package com.resortmanagement.system.room.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.room.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {
    // TODO: add custom queries if needed
}

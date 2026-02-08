package com.resortmanagement.system.room.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.room.entity.Room;
import com.resortmanagement.system.room.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room getRoom(UUID id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room updateRoom(UUID id, Room updated) {
        Room room = getRoom(id);

        room.setRoomNumber(updated.getRoomNumber());
        room.setFloor(updated.getFloor());
        room.setStatus(updated.getStatus());
        room.setDescription(updated.getDescription());
        room.setMaxOccupancy(updated.getMaxOccupancy());
        room.setRoomTypeId(updated.getRoomTypeId());

        return roomRepository.save(room);
    }

    public void deleteRoom(UUID id) {
        roomRepository.deleteById(id);
    }
}


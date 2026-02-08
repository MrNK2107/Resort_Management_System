package com.resortmanagement.system.room.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.room.entity.RoomType;
import com.resortmanagement.system.room.repository.RoomTypeRepository;

@Service
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    public RoomType create(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    public List<RoomType> getAll() {
        return roomTypeRepository.findAll();
    }
}


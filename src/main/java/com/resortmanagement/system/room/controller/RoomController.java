/*
TODO: RoomController.java
Purpose:
 - Room management and availability endpoints.
Endpoints:
 - GET /api/v1/rooms/available?roomTypeId=&from=&to=
 - POST /api/v1/rooms -> create room
 - GET /api/v1/rooms/{id}
Responsibilities:
 - Availability endpoint must consider Room.status, RoomBlock, and confirmed reservations (by roomType).
File: room/controller/RoomController.java
*/
package com.resortmanagement.system.room.controller;

import java.util.List;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resortmanagement.system.room.entity.Room;
import com.resortmanagement.system.room.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public Room create(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @GetMapping("/{id}")
    public Room get(@PathVariable UUID id) {
        return roomService.getRoom(id);
    }

    @GetMapping
    public List<Room> getAll() {
        return roomService.getAllRooms();
    }

    @PutMapping("/{id}")
    public Room update(@PathVariable UUID id, @RequestBody Room room) {
        return roomService.updateRoom(id, room);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        roomService.deleteRoom(id);
    }
}

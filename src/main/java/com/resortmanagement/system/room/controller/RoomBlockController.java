/*
TODO: RoomBlockController.java
Purpose:
 - Manage room blocks (out of order or reserved for maintenance).
Endpoints:
 - POST /api/v1/room-blocks
 - GET /api/v1/room-blocks?roomId=...
Responsibilities:
 - Use RoomBlockService to prevent availability and possibly create RoomBlock from MaintenanceRequest.
File: room/controller/RoomBlockController.java
*/
package com.resortmanagement.system.room.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resortmanagement.system.room.entity.RoomBlock;
import com.resortmanagement.system.room.service.RoomBlockService;

@RestController
@RequestMapping("/api/room-blocks")
public class RoomBlockController {

    private final RoomBlockService service;

    public RoomBlockController(RoomBlockService service) {
        this.service = service;
    }

    @PostMapping
    public RoomBlock block(@RequestBody RoomBlock block) {
        return service.block(block);
    }

    @GetMapping
    public List<RoomBlock> active() {
        return service.getActiveBlocks();
    }

    @DeleteMapping("/{id}")
    public void unblock(@PathVariable UUID id) {
        service.unblock(id);
    }
}

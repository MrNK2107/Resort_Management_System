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


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.resortmanagement.system.room.service.RoomBlockService;
import com.resortmanagement.system.room.entity.RoomBlock;

@RestController
@RequestMapping("/api/room/roomblocks")
public class RoomBlockController {

    private final RoomBlockService service;

    public RoomBlockController(RoomBlockService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RoomBlock>> getAll() {
        // TODO: add pagination and filtering params
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomBlock> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RoomBlock> create(@RequestBody RoomBlock entity) {
        // TODO: add validation
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomBlock> update(@PathVariable Long id, @RequestBody RoomBlock entity) {
        // TODO: implement update logic
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

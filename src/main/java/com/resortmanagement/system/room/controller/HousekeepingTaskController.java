/*
TODO: HousekeepingTaskController.java
Purpose:
 - Manage housekeeping tasks: schedule cleanings, mark completed.
Endpoints:
 - POST /api/v1/housekeeping/tasks
 - GET /api/v1/rooms/{roomId}/housekeeping
Responsibilities:
 - Create tasks when reservation checks out; assign staff; update room status.
File: room/controller/HousekeepingTaskController.java
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

import com.resortmanagement.system.room.entity.HousekeepingTask;
import com.resortmanagement.system.room.service.HousekeepingTaskService;

@RestController
@RequestMapping("/api/housekeeping")
public class HousekeepingTaskController {

    private final HousekeepingTaskService service;

    public HousekeepingTaskController(HousekeepingTaskService service) {
        this.service = service;
    }

    @PostMapping
    public HousekeepingTask create(@RequestBody HousekeepingTask task) {
        return service.create(task);
    }

    @GetMapping
    public List<HousekeepingTask> pending() {
        return service.getPending();
    }

    @DeleteMapping("/{id}")
    public void complete(@PathVariable UUID id) {
        service.complete(id);
    }
}

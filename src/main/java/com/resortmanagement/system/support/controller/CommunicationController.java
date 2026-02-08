/*
TODO: CommunicationController.java
Purpose:
 - Log or send communications (email/SMS) to guests; store sent communications for audit.
Endpoints:
 - POST /api/v1/communications/send -> send message (email/sms) and store record
 - GET /api/v1/communications?guestId=...
Responsibilities:
 - Use Integration module (email/SMS provider) to actually send messages.
 - Store communication in DB for audit trail (Communication entity).
File: support/controller/CommunicationController.java
*/
package com.resortmanagement.system.support.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.resortmanagement.system.support.service.CommunicationService;
import com.resortmanagement.system.support.entity.Communication;

@RestController
@RequestMapping("/api/communications")
public class CommunicationController {

    private final CommunicationService service;

    public CommunicationController(CommunicationService service) {
        this.service = service;
    }

    @PostMapping
    public Communication create(@RequestBody Communication communication) {
        return service.create(communication);
    }

    @GetMapping
    public List<Communication> getAll() {
        return service.getAll();
    }
}

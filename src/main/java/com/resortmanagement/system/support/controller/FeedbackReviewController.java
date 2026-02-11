package com.resortmanagement.system.support.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.resortmanagement.system.support.dto.request.FeedbackReviewRequest;
import com.resortmanagement.system.support.mapper.FeedbackReviewMapper;
import com.resortmanagement.system.support.service.FeedbackReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackReviewController {

    private final FeedbackReviewService service;

    @PostMapping
    public Object create(@RequestBody FeedbackReviewRequest request) {
        return FeedbackReviewMapper.toResponse(service.create(request));
    }

    @GetMapping
    public List<?> getAll() {
        return service.getAll()
                .stream()
                .map(FeedbackReviewMapper::toResponse)
                .toList();
    }

    @PutMapping("/{id}/respond/{staffId}")
    public Object respond(@PathVariable UUID id, @PathVariable UUID staffId) {
        return FeedbackReviewMapper.toResponse(service.respond(id, staffId));
    }
}

/*
TODO: FeedbackReviewController.java
Purpose:
 - CRUD for guest feedback and reviews.
Endpoints:
 - POST /api/v1/reservations/{id}/reviews
 - GET /api/v1/reservations/{id}/reviews
Responsibilities:
 - Use FeedbackReviewService to save feedback; link to reservation for follow-up.
File: support/controller/FeedbackReviewController.java
*/
package com.resortmanagement.system.support.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resortmanagement.system.support.entity.FeedbackReview;
import com.resortmanagement.system.support.service.FeedbackReviewService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackReviewController {

    private final FeedbackReviewService service;

    public FeedbackReviewController(FeedbackReviewService service) {
        this.service = service;
    }

    @PostMapping
    public FeedbackReview create(@RequestBody FeedbackReview review) {
        return service.create(review);
    }

    @GetMapping
    public List<FeedbackReview> getAll() {
        return service.getAll();
    }
}

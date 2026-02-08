package com.resortmanagement.system.support.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.support.entity.FeedbackReview;
import com.resortmanagement.system.support.repository.FeedbackReviewRepository;

@Service
public class FeedbackReviewService {

    private final FeedbackReviewRepository repository;

    public FeedbackReviewService(FeedbackReviewRepository repository) {
        this.repository = repository;
    }

    public FeedbackReview create(FeedbackReview review) {
        return repository.save(review);
    }

    public List<FeedbackReview> getAll() {
        return repository.findByDeletedFalse();
    }
}


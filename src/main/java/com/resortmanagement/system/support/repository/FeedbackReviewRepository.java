package com.resortmanagement.system.support.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.resortmanagement.system.common.repository.SoftDeleteRepository;
import com.resortmanagement.system.support.entity.FeedbackReview;

@Repository
public interface FeedbackReviewRepository
        extends SoftDeleteRepository<FeedbackReview, UUID> {
}

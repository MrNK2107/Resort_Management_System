package com.resortmanagement.system.support.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.support.entity.FeedbackReview;

@Repository
public interface FeedbackReviewRepository extends JpaRepository<FeedbackReview, UUID> {
}

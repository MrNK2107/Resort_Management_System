package com.resortmanagement.system.support.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.booking.repository.ReservationRepository;
import com.resortmanagement.system.common.guest.GuestRepository;
import com.resortmanagement.system.support.dto.request.FeedbackReviewRequest;
import com.resortmanagement.system.support.entity.FeedbackReview;
import com.resortmanagement.system.support.repository.FeedbackReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedbackReviewService {

    private final FeedbackReviewRepository reviewRepo;
    private final GuestRepository guestRepo;
    private final ReservationRepository reservationRepo;

    public FeedbackReview create(FeedbackReviewRequest request) {

        FeedbackReview review = new FeedbackReview();

        review.setGuest(
                guestRepo.findById(request.getGuestId())
                        .orElseThrow()
        );

        review.setReservation(
                reservationRepo.findById(request.getReservationId())
                        .orElseThrow()
        );

        review.setRating(request.getRating());
        review.setComments(request.getComments());

        return reviewRepo.save(review);
    }

    public List<FeedbackReview> getAll() {
        return reviewRepo.findAll();
    }

    public FeedbackReview respond(UUID id, UUID staffId) {

        FeedbackReview review = reviewRepo.findById(id).orElseThrow();

        review.setResponseBy(staffId);
        review.setRespondedAt(LocalDateTime.now());

        return reviewRepo.save(review);
    }
}

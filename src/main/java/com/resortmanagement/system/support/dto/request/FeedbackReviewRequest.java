package com.resortmanagement.system.support.dto.request;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackReviewRequest {

    private UUID guestId;
    private UUID reservationId;
    private Integer rating;
    private String comments;
}

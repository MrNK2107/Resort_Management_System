/*
TODO: FeedbackReview.java
Purpose:
 - Guest feedback and rating for a stay or service.
Fields:
 - id UUID
 - guestId UUID
 - reservationId UUID
 - rating int (1..5)
 - comments String
 - responseBy UUID (staff responding)
 - respondedAt Instant
 - extends Auditable
Notes:
 - Consider moderation + public/private flags.
File: support/entity/FeedbackReview.java
*/
package com.resortmanagement.system.support.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.resortmanagement.system.common.audit.AuditableSoftDeletable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "feedback_reviews")
@Getter
@Setter
public class FeedbackReview extends AuditableSoftDeletable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @Column(name = "guest_id", nullable = false)
    private UUID guestId;

    private Integer rating;

    private String comments;

    @Column(name = "response_by")
    private UUID responseBy;

    @Column(name = "responded_at")
    private LocalDateTime respondedAt;

    @Column(name = "reservation_id")
    private UUID reservationId;
}

package com.resortmanagement.system.marketing.mapper;

import org.springframework.stereotype.Component;
import com.resortmanagement.system.marketing.dto.loyaltymember.LoyaltyMemberRequest;
import com.resortmanagement.system.marketing.dto.loyaltymember.LoyaltyMemberResponse;
import com.resortmanagement.system.marketing.entity.LoyaltyMember;

@Component
public class LoyaltyMemberMapper {

    /**
     * Convert LoyaltyMember entity to LoyaltyMemberResponse DTO
     */
    public LoyaltyMemberResponse toResponse(LoyaltyMember entity) {
        if (entity == null) {
            return null;
        }

        // In a real application, fetch guest name from Guest service or repository
        String guestName = "Guest " + entity.getGuestId();

        return LoyaltyMemberResponse.builder()
                .id(entity.getId())
                .guestId(entity.getGuestId())
                .guestName(guestName)
                .tier(entity.getTier())
                .pointsBalance(entity.getPointsBalance())
                .enrolledAt(entity.getEnrolledAt())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    /**
     * Convert LoyaltyMemberRequest DTO to LoyaltyMember entity
     */
    public LoyaltyMember toEntity(LoyaltyMemberRequest request) {
        if (request == null) {
            return null;
        }

        return LoyaltyMember.builder()
                .guestId(request.getGuestId())
                .tier(request.getTier())
                .pointsBalance(request.getPointsBalance())
                .enrolledAt(request.getEnrolledAt())
                .status(request.getStatus())
                .build();
    }

    /**
     * Update existing LoyaltyMember entity from LoyaltyMemberRequest DTO
     */
    public void updateEntity(LoyaltyMember entity, LoyaltyMemberRequest request) {
        if (entity == null || request == null) {
            return;
        }

        entity.setGuestId(request.getGuestId());
        entity.setTier(request.getTier());
        entity.setPointsBalance(request.getPointsBalance());
        entity.setEnrolledAt(request.getEnrolledAt());
        entity.setStatus(request.getStatus());
    }
}

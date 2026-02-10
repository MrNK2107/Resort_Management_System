package com.resortmanagement.system.marketing.dto.loyaltymember;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import com.resortmanagement.system.marketing.entity.LoyaltyMember.MemberStatus;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoyaltyMemberRequest {
    private UUID guestId;
    private String tier;
    private BigDecimal pointsBalance;
    private Instant enrolledAt;
    private MemberStatus status;
}

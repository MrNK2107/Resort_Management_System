package com.resortmanagement.system.marketing.dto.promotion;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.resortmanagement.system.marketing.entity.Promotion.DiscountType;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionRequest {
    private String code; // Matches entity field
    private String description;
    private DiscountType discountType;
    private BigDecimal value; // Matches entity field (not discountValue)
    private LocalDate validFrom; // Matches entity field
    private LocalDate validTo; // Matches entity field
    private Integer usageLimit;
    private String terms;
}

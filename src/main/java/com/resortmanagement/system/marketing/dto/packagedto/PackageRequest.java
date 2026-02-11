package com.resortmanagement.system.marketing.dto.packagedto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PackageRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate validFrom;
    private LocalDate validTo;
    private Integer usageLimit;
}

package com.resortmanagement.system.marketing.dto.packagedto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PackageResponse {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate validFrom;
    private LocalDate validTo;
    private Integer usageLimit;
    private Instant createdAt;
    private Instant updatedAt;
}

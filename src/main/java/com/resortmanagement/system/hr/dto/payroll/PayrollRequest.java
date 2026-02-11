package com.resortmanagement.system.hr.dto.payroll;

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
public class PayrollRequest {
    private UUID employeeId; // Will be used to fetch Employee entity in mapper
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private BigDecimal grossPay;
    private BigDecimal deductions;
    private BigDecimal netPay;
    private Instant paidAt;
}

package com.resortmanagement.system.hr.dto.employee;

import java.time.LocalDate;
import com.resortmanagement.system.hr.entity.Employee.EmployeeStatus;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate hireDate;
    private EmployeeStatus status;
}

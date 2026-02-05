/*
TODO: HR repositories and services guidelines
Repositories:
 - Standard JpaRepository for each entity.

Services:
 - EmployeeService: create/modify/disable employees; optionally integrate with IdP.
 - ShiftScheduleService: enforce constraints and manage shifts.
 - PayrollService: generate payroll; mark paid via accounting integration.

File: hr/repository/<File>.java, hr/service/<File>.java
*/
package com.resortmanagement.system.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.hr.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // TODO: add custom queries if needed
}

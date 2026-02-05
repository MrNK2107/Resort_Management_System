package com.resortmanagement.system.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.hr.entity.Payroll;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    // TODO: add custom queries if needed
}

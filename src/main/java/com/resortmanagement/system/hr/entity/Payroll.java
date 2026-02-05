/*
TODO: Payroll.java
Purpose:
 - Payroll record for employee payments, taxes, deductions.
Fields:
 - id UUID
 - employeeId UUID
 - periodStart, periodEnd
 - grossPay BigDecimal
 - deductions BigDecimal
 - netPay BigDecimal
 - paidAt Instant
 - extends Auditable
Notes:
 - Payroll must be immutable after creation (except for corrections which should create adjustment records).
File: hr/entity/Payroll.java
*/
package com.resortmanagement.system.hr.entity;

public class Payroll {
    // TODO: fields, constructors, getters, setters
}
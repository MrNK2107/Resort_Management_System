/*
TODO: Employee.java
Purpose:
 - HR employee entity that also acts as system users (or link to authentication provider).
Fields:
 - id: UUID
 - firstName, lastName, email, phone
 - roleIds: relationship to Role (ManyToMany via EmployeeRole) or use EmployeeRole entity
 - credentialsHash: String (password hash) - or use external IdP (preferred)
 - hireDate LocalDate
 - status enum (ACTIVE/INACTIVE)
 - extends Auditable (critical)
Notes:
 - If employee is to be used for authentication, do not store plain text passwords; use password encoder and security best practices.
File: hr/entity/Employee.java
*/
package com.resortmanagement.system.hr.entity;

public class Employee {
    // TODO: fields, constructors, getters, setters
}
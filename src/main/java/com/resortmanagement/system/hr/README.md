# HR Domain

Purpose
- Manages employees, roles, payroll, and shift scheduling across the property.
- Provides staff management, role-based access control data and integration points for user provisioning.

Interactions with other domains
- Security: employee data integrates with authentication/authorization.
- Payroll: payroll entities interact with finance for payouts and ledger entries.
- Scheduling: ShiftSchedule ties into department staffing and operations (FNB, Housekeeping, Frontdesk).

Key artifacts
- Entities:
  - `Employee.java`, `EmployeeRole.java`, `Role.java`, `ShiftSchedule.java`, `Payroll.java`
- Controllers:
  - `EmployeeController.java`, `EmployeeRoleController.java`, `RoleController.java`, `ShiftScheduleController.java`, `PayrollController.java`
- Services:
  - `EmployeeService.java`, `EmployeeRoleService.java`, `RoleService.java`, `ShiftScheduleService.java`, `PayrollService.java`
- Repositories:
  - `EmployeeRepository.java`, `EmployeeRoleRepository.java`, `RoleRepository.java`, `ShiftScheduleRepository.java`, `PayrollRepository.java`

Transaction boundaries
- Payroll processing and pay runs should be transactional and immutable (use adjustments rather than direct edits).
- Shift assignment swaps and role changes should be transactional to keep schedules consistent.

Auditing, soft delete, concurrency
- **Auditing**: Employee and payroll entities should extend `Auditable` for compliance.
- **Soft delete**: Use soft-delete for employees if required for GDPR; provide anonymization procedures.
- **Concurrency**: Use constraints to avoid overlapping shifts; validate in service with DB-level checks.

Security roles
- HR Admin: full CRUD on employee/role data and payroll triggers
- Manager: shift assignment and limited employee operations
- Auditor: read-only access to payroll and audit logs

Design patterns used
- Strategy: payroll calculation rules
- Template Method: payroll report generation
- Builder/Factory: constructing complex payroll and employee DTOs

Typical workflows
- Hiring workflow: create employee -> assign roles -> provision access -> schedule shifts -> include employee in payroll runs.

Notes
- Keep PII handling compliant; use role-based access and data minimization.
- All payroll and sensitive operations must be audited and restricted.
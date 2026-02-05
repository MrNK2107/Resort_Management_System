# Reporting Domain

Purpose
- Provides reporting, auditing, and read-only access to historical events and aggregated metrics across domains.

Interactions with other domains
- Receives events from booking, billing, inventory and marketing.
- Provides audit and report endpoints for compliance and business intelligence.

Key artifacts
- Entities: `AuditLog.java`, `ReportMeta.java`
- Controllers: `AuditLogController.java`, `ReportMetaController.java`
- Services: `AuditLogService.java`, `ReportMetaService.java`
- Repositories: `AuditLogRepository.java`, `ReportMetaRepository.java`

Transaction boundaries
- Reporting reads should be non-transactional; report generation may snapshot data.
- Audit writes happen in the context of the business transaction that triggers them.

Auditing, soft delete, concurrency
- **Auditing**: AuditLog stores detailed change history; it is append-only.
- **Soft delete**: reporting metadata can be soft-deleted; audits must be immutable.
- **Concurrency**: reporting jobs should use snapshot or read-consistent queries to avoid inconsistent reads.

Security roles
- Auditor: read access to audit logs and reports
- BI Analyst: read access to reporting APIs

Design patterns used
- Template Method: report generation
- Adapter: export connectors (CSV, BI tools)

Typical workflows
- Business transactions write AuditLog entries -> reporting services aggregate and expose data to BI or scheduled reports.

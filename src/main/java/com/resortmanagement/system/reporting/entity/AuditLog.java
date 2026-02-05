/*
TODO: AuditLog.java
Purpose:
 - Stores detailed history of changes (what changed, from->to, reason).
Fields:
 - id UUID
 - targetEntity String
 - targetId UUID
 - action String (CREATE/UPDATE/DELETE)
 - performedBy String
 - timestamp Instant
 - changesJson String (old/new values)
 - reason String (optional)
Notes:
 - Write entries in service layer where complex business changes occur.
 - Optionally create DB triggers for guaranteed capture of table-level changes but service-level logging gives richer context (reason).
File: reporting/entity/AuditLog.java
*/
package com.resortmanagement.system.reporting.entity;

public class AuditLog {
    // TODO: fields, constructors, getters, setters
}
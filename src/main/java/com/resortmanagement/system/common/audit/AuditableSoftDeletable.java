package com.resortmanagement.system.common.audit;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class AuditableSoftDeletable extends Auditable {

    @Column(name = "is_deleted", nullable = false)
    protected boolean deleted = false;

    @Column(name = "deleted_at")
    protected Instant deletedAt;
}
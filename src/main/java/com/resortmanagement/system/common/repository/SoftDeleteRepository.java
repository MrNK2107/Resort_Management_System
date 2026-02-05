package com.resortmanagement.system.common.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface SoftDeleteRepository<T, ID>
        extends JpaRepository<T, ID> {

    @Modifying
    @Query("""
        update #{#entityName} e
        set e.deleted = true,
            e.deletedAt = :deletedAt
        where e.id = :id
    """)
    void softDeleteById(@Param("id") ID id,
                        @Param("deletedAt") Instant deletedAt);
              
    Optional<T> findByIdAndDeletedFalse(ID id);
    
    List<T> findByDeletedFalse();
}

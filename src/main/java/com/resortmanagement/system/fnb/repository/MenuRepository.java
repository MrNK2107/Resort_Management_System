package com.resortmanagement.system.fnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.fnb.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    // TODO: add custom queries if needed
}

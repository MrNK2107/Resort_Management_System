package com.resortmanagement.system.fnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.fnb.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // TODO: add custom queries if needed
}

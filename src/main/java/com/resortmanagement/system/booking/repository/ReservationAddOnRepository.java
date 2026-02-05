package com.resortmanagement.system.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.booking.entity.ReservationAddOn;

@Repository
public interface ReservationAddOnRepository extends JpaRepository<ReservationAddOn, Long> {
    // TODO: add custom queries if needed
}

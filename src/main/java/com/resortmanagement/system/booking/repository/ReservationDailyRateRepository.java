package com.resortmanagement.system.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.booking.entity.ReservationDailyRate;

@Repository
public interface ReservationDailyRateRepository extends JpaRepository<ReservationDailyRate, Long> {
    // TODO: add custom queries if needed
}

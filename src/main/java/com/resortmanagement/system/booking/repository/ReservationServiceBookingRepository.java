package com.resortmanagement.system.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.booking.entity.ReservationServiceBooking;

@Repository
public interface ReservationServiceBookingRepository extends JpaRepository<ReservationServiceBooking, Long> {
    // TODO: add custom queries if needed
}

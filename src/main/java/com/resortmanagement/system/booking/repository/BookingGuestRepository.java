package com.resortmanagement.system.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resortmanagement.system.booking.entity.BookingGuest;

@Repository
public interface BookingGuestRepository extends JpaRepository<BookingGuest, Long> {
    // TODO: add custom queries if needed
}

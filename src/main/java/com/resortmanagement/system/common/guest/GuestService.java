/*
guestService.java
Purpose:
 - Business logic for guest management (merge duplicates, GDPR export/erase).
Methods:
 - createGuest(CreateGuestDto)
 - updateGuest(UUID id, UpdateGuestDto)
 - mergeGuest(UUID sourceId, UUID targetId) // reassign bookings/payments
 - anonymizeGuest(UUID id) // for GDPR erase
Guidance:
 - Use transactions for merge operations.
 - Use Auditable for traceability.
File: common/Guest/guestService.java
*/

package com.resortmanagement.system.common.guest;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resortmanagement.system.common.exception.ApplicationException;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    // CREATE
    @Transactional
    public Guest createGuest(Guest guest) {
        if (guestRepository.existsByEmail(guest.getEmail())) {
            throw new ApplicationException("Guest with email already exists");
        }
        return guestRepository.save(guest);
    }

    // READ
    @Transactional(readOnly = true)
    public Guest getGuest(UUID guestId) {
        return guestRepository.findByIdAndDeletedFalse(guestId)
                .orElseThrow(() -> new ApplicationException("Guest not found"));
    }

    // UPDATE
    @Transactional
    public Guest updateGuest(UUID guestId, Guest updatedGuest) {
        Guest existing = getGuest(guestId);

        existing.setFirstName(updatedGuest.getFirstName());
        existing.setLastName(updatedGuest.getLastName());
        existing.setPhone(updatedGuest.getPhone());
        existing.setAddress(updatedGuest.getAddress());
        existing.setDob(updatedGuest.getDob());

        return guestRepository.save(existing);
    }

    // SOFT DELETE
    @Transactional
    public void deleteGuest(UUID guestId) {
        guestRepository.softDeleteById(guestId, Instant.now());
    }

    // GDPR ANONYMIZATION (VERY IMPORTANT)
    @Transactional
    public void anonymizeGuest(UUID guestId) {
        Guest guest = getGuest(guestId);

        guest.setFirstName("ANONYMIZED");
        guest.setLastName("ANONYMIZED");
        guest.setEmail("anon-" + guestId + "@example.com");
        guest.setPhone(null);
        guest.setAddress(null);
        guest.setDob(null);

        guestRepository.save(guest);
    }

    /*
     * FUTURE (do not implement now, but planned):
     * mergeGuest(UUID sourceId, UUID targetId)
     * - Move reservations, invoices, orders
     * - Soft delete source guest
     */
}    

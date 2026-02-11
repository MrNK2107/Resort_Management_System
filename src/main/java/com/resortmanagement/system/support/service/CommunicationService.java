package com.resortmanagement.system.support.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.resortmanagement.system.booking.repository.ReservationRepository;
import com.resortmanagement.system.common.guest.GuestRepository;
import com.resortmanagement.system.support.dto.request.CommunicationCreateRequest;
import com.resortmanagement.system.support.dto.response.CommunicationResponse;
import com.resortmanagement.system.support.entity.Communication;
import com.resortmanagement.system.support.enums.CommunicationStatus;
import com.resortmanagement.system.support.mapper.CommunicationMapper;
import com.resortmanagement.system.support.repository.CommunicationRepository;

@Service
public class CommunicationService {

    private final CommunicationRepository repo;
    private final GuestRepository guestRepo;
    private final ReservationRepository reservationRepo;

    public CommunicationService(
            CommunicationRepository repo,
            GuestRepository guestRepo,
            ReservationRepository reservationRepo) {

        this.repo = repo;
        this.guestRepo = guestRepo;
        this.reservationRepo = reservationRepo;
    }

    public CommunicationResponse create(CommunicationCreateRequest req) {

        Communication entity = new Communication();

        if(req.getGuestId() != null) {
            entity.setGuest(
                guestRepo.findById(req.getGuestId())
                    .orElseThrow(() -> new RuntimeException("Guest not found"))
            );
        }

        if(req.getReservationId() != null) {
            entity.setReservation(
                reservationRepo.findById(req.getReservationId())
                    .orElseThrow(() -> new RuntimeException("Reservation not found"))
            );
        }

        entity.setType(req.getType());
        entity.setTo(req.getTo());
        entity.setSubject(req.getSubject());
        entity.setBodySnippet(req.getBodySnippet());
        entity.setChannel(req.getChannel());
        entity.setStatus(CommunicationStatus.SENT);
        entity.setSentAt(LocalDateTime.now());

        return CommunicationMapper.toResponse(repo.save(entity));
    }

    public List<CommunicationResponse> getAll() {

        return repo.findByDeletedFalse()
                .stream()
                .map(CommunicationMapper::toResponse)
                .toList();
    }

    public void delete(UUID id) {

        Communication entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Communication not found"));

        entity.setDeleted(true);
        repo.save(entity);
    }
}


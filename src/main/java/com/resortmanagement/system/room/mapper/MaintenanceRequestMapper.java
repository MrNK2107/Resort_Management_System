package com.resortmanagement.system.room.mapper;

import java.util.List;

import com.resortmanagement.system.booking.entity.BookingGuest;
import com.resortmanagement.system.booking.repository.BookingGuestRepository;
import com.resortmanagement.system.room.dto.request.MaintenanceRequestCreateRequest;
import com.resortmanagement.system.room.dto.response.MaintenanceRequestResponse;
import com.resortmanagement.system.room.entity.MaintenanceRequest;

public class MaintenanceRequestMapper {

    private MaintenanceRequestMapper() {}

    // Create entity from DTO
    public static MaintenanceRequest toEntity(
            MaintenanceRequestCreateRequest dto,
            BookingGuestRepository guestRepo) {

        MaintenanceRequest entity = new MaintenanceRequest();

        entity.setRoomOrFacilityId(dto.getRoomOrFacilityId());
        entity.setDescription(dto.getDescription());
        entity.setSeverity(dto.getSeverity());
        entity.setStatus(dto.getStatus());

        BookingGuest reportedBy = guestRepo.findById(dto.getReportedById())
                .orElseThrow(() -> new RuntimeException("BookingGuest not found"));
        entity.setReportedBy(reportedBy);

        return entity;
    }

    // Map entity to response DTO
    public static MaintenanceRequestResponse toResponse(MaintenanceRequest entity) {
        if (entity == null) return null;

        MaintenanceRequestResponse res = new MaintenanceRequestResponse();

        res.setId(entity.getId());
        res.setRoomOrFacilityId(entity.getRoomOrFacilityId());
        res.setRoomBlockId(entity.getRoomBlock() != null ? entity.getRoomBlock().getId() : null);
        res.setReportedById(entity.getReportedBy() != null ? entity.getReportedBy().getId() : null);
        res.setAssignedStaffId(entity.getAssignedStaff() != null ? entity.getAssignedStaff().getId() : null);

        res.setDescription(entity.getDescription());
        res.setSeverity(entity.getSeverity());
        res.setStatus(entity.getStatus());
        res.setResolvedAt(entity.getResolvedAt());

        return res;
    }

    // Map list of entities
    public static List<MaintenanceRequestResponse> toResponseList(List<MaintenanceRequest> list) {
        return list.stream().map(MaintenanceRequestMapper::toResponse).toList();
    }
}

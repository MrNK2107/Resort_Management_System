package com.resortmanagement.system.fnb.mapper;

import org.springframework.stereotype.Component;

import com.resortmanagement.system.fnb.dto.request.ActivityEventRequest;
import com.resortmanagement.system.fnb.dto.response.ActivityEventResponse;
import com.resortmanagement.system.fnb.entity.ActivityEvent;
import com.resortmanagement.system.fnb.entity.ActivityEventStatus;

@Component
public class ActivityEventMapper {

    public ActivityEvent toEntity(ActivityEventRequest request) {
        if (request == null) {
            return null;
        }
        ActivityEvent entity = new ActivityEvent();
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setStartTime(request.getStartTime());
        entity.setEndTime(request.getEndTime());
        entity.setCapacity(request.getCapacity());
        entity.setInstructorId(request.getInstructorId());
        entity.setPrice(request.getPrice());
        entity.setStatus(ActivityEventStatus.SCHEDULED);
        return entity;
    }

    public ActivityEventResponse toResponse(ActivityEvent entity) {
        if (entity == null) {
            return null;
        }
        ActivityEventResponse response = new ActivityEventResponse();
        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setDescription(entity.getDescription());
        response.setStartTime(entity.getStartTime());
        response.setEndTime(entity.getEndTime());
        response.setCapacity(entity.getCapacity());
        response.setInstructorId(entity.getInstructorId());
        response.setPrice(entity.getPrice());
        response.setStatus(entity.getStatus());
        return response;
    }

    public void updateEntity(ActivityEvent entity, ActivityEventRequest request) {
        if (entity == null || request == null) {
            return;
        }
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setStartTime(request.getStartTime());
        entity.setEndTime(request.getEndTime());
        entity.setCapacity(request.getCapacity());
        entity.setInstructorId(request.getInstructorId());
        entity.setPrice(request.getPrice());
    }
}

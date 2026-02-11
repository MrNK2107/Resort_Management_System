package com.resortmanagement.system.support.dto.request;

import java.util.UUID;

import com.resortmanagement.system.support.enums.CommunicationType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunicationCreateRequest {

    private UUID guestId;

    private Long reservationId;

    @NotNull
    private CommunicationType type;

    @NotBlank
    private String to;

    private String subject;

    private String bodySnippet;

    private String channel;
}

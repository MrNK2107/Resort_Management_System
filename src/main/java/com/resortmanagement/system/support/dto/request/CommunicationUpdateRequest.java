package com.resortmanagement.system.support.dto.request;

import com.resortmanagement.system.support.enums.CommunicationStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunicationUpdateRequest {

    private CommunicationStatus status;

    private String bodySnippet;
}


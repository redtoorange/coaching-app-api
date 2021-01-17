package com.andrewmcguiness.coachingappapi.resource.vm;

import com.andrewmcguiness.coachingappapi.dto.RequestDto;

import java.io.Serializable;

public class RequestVm implements Serializable {
    private Long id;
    private Long coachId;
    private String email;
    private String message;

    public RequestVm(Long id, Long coachId, String email, String message) {
        this.id = id;
        this.coachId = coachId;
        this.email = email;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static RequestVm toVm(RequestDto dto) {
        if (dto == null) {
            return null;
        }

        return new RequestVm(
            dto.getId(),
            dto.getCoachId(),
            dto.getEmail(),
            dto.getMessage()
        );
    }

    public static RequestDto toDto(RequestVm vm) {
        if (vm == null) {
            return null;
        }

        return new RequestDto(
            vm.getId(),
            vm.getCoachId(),
            vm.getEmail(),
            vm.getMessage()
        );
    }
}

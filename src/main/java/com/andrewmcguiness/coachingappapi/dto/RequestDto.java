package com.andrewmcguiness.coachingappapi.dto;

public class RequestDto {
    private Long id;
    private Long coachId;
    private String email;
    private String message;

    public RequestDto(Long id, Long coachId, String email, String message) {
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

    @Override
    public String toString() {
        return "RequestDto{" +
                "id=" + id +
                ", coachId=" + coachId +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

package com.andrewmcguiness.coachingappapi.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "request", schema = "coaching")
@SequenceGenerator(name = "requestSequence", sequenceName = "requestSequence", schema = "coaching", initialValue = 1000)
public class RequestEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requestSequence")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "coach_id")
    private Long coachId;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "message", nullable = false, length = 50)
    private String message;

    public RequestEntity() {
    }

    public RequestEntity(Long id, Long coachId, String email, String message) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestEntity entity = (RequestEntity) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

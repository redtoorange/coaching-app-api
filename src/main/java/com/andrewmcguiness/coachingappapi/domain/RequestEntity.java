package com.andrewmcguiness.coachingappapi.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "request", schema = "coaching")
@SequenceGenerator(name = "requestSequence", sequenceName = "requestSequence", schema = "coaching", initialValue = 1000)
public class RequestEntity extends IdEntity implements Serializable {
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
}

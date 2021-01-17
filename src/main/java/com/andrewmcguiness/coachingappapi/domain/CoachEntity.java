package com.andrewmcguiness.coachingappapi.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "coach", schema = "coaching")
@SequenceGenerator(name = "coachSequence", sequenceName = "coachSequence", schema = "coaching", initialValue = 1000)
public class CoachEntity extends IdEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coachSequence")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "hourly_rate", nullable = false)
    private Double hourlyRate;

    @Column(name = "description", length = 250)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "coach_area", schema = "coaching",
            joinColumns = {@JoinColumn(name = "coach_id")},
            inverseJoinColumns = {@JoinColumn(name = "area_id")}
    )
    Set<AreaEntity> areas = new HashSet<>();
}

package com.andrewmcguiness.coachingappapi.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "coach", schema = "coaching")
@SequenceGenerator(name = "coachSequence", sequenceName = "coachSequence", schema = "coaching", initialValue = 1000)
public class CoachEntity implements Serializable {
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

    public CoachEntity() {
    }

    public CoachEntity(Long id, String firstName, String lastName, Double hourlyRate, String description, Set<AreaEntity> areas) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
        this.description = description;
        this.areas = areas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<AreaEntity> getAreas() {
        return areas;
    }

    public void setAreas(Set<AreaEntity> areas) {
        this.areas = areas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoachEntity that = (CoachEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

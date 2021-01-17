package com.andrewmcguiness.coachingappapi.dto;


import java.util.Set;

public class CoachDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Double hourlyRate;
    private String description;
    private Set<AreaDto> areas;

    public CoachDto(Long id, String firstName, String lastName, Double hourlyRate, String description, Set<AreaDto> areas) {
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

    public Set<AreaDto> getAreas() {
        return areas;
    }

    public void setAreas(Set<AreaDto> areas) {
        this.areas = areas;
    }
}

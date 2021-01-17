package com.andrewmcguiness.coachingappapi.resource.vm;

import com.andrewmcguiness.coachingappapi.dto.AreaDto;
import com.andrewmcguiness.coachingappapi.dto.CoachDto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CoachVm implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Double hourlyRate;
    private String description;
    private List<String> areas;

    public CoachVm(Long id, String firstName, String lastName, Double hourlyRate, String description, List<String> areas) {
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

    public List<String> getAreas() {
        return areas;
    }

    public void setAreas(List<String> areas) {
        this.areas = areas;
    }

    @Override
    public String toString() {
        return "CoachVm{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", hourlyRate=" + hourlyRate +
            ", description='" + description + '\'' +
            ", areas=" + areas +
            '}';
    }

    public static CoachDto toDto(CoachVm vm) {
        if (vm == null) {
            return null;
        }

        Set<AreaDto> areas = vm.areas.stream()
            .map(a -> new AreaDto(null, a))
            .collect(Collectors.toSet());

        return new CoachDto(
            vm.getId(),
            vm.getFirstName(),
            vm.getLastName(),
            vm.getHourlyRate(),
            vm.getDescription(),
            areas
        );
    }

    public static CoachVm toVm(CoachDto dto) {
        if (dto == null) {
            return null;
        }

        return new CoachVm(
            dto.getId(),
            dto.getFirstName(),
            dto.getLastName(),
            dto.getHourlyRate(),
            dto.getDescription(),
            dto.getAreas().stream()
                .map(AreaDto::getAreaName)
                .collect(Collectors.toList())
        );
    }
}

package com.andrewmcguiness.coachingappapi.resource.vm;

import com.andrewmcguiness.coachingappapi.dto.AreaDto;
import com.andrewmcguiness.coachingappapi.dto.CoachDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CoachVm implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Double hourlyRate;
    private String description;
    private List<String> areas;

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

package com.andrewmcguiness.coachingappapi.dto;


import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CoachDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Double hourlyRate;
    private String description;
    private Set<AreaDto> areas;
}

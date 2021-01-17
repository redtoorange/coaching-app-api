package com.andrewmcguiness.coachingappapi.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequestDto {
    private Long id;
    private Long coachId;
    private String email;
    private String message;
}

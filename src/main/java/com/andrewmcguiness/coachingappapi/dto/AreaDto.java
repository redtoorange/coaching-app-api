package com.andrewmcguiness.coachingappapi.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AreaDto implements Serializable {
    private Long id;
    private String areaName;
}

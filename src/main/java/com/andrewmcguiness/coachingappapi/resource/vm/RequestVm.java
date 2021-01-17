package com.andrewmcguiness.coachingappapi.resource.vm;

import com.andrewmcguiness.coachingappapi.dto.RequestDto;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequestVm implements Serializable {
    private Long id;
    private Long coachId;
    private String email;
    private String message;


    public static RequestVm toVm(RequestDto dto) {
        if (dto == null) {
            return null;
        }

        return new RequestVm(
            dto.getId(),
            dto.getCoachId(),
            dto.getEmail(),
            dto.getMessage()
        );
    }

    public static RequestDto toDto(RequestVm vm) {
        if (vm == null) {
            return null;
        }

        return new RequestDto(
            vm.getId(),
            vm.getCoachId(),
            vm.getEmail(),
            vm.getMessage()
        );
    }
}

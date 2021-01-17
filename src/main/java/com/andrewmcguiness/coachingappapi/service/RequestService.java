package com.andrewmcguiness.coachingappapi.service;


import com.andrewmcguiness.coachingappapi.domain.RequestEntity;
import com.andrewmcguiness.coachingappapi.dto.RequestDto;
import com.andrewmcguiness.coachingappapi.repository.RequestRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    private final RequestRepository requestRepository;
    private final CoachService coachService;

    public RequestService(RequestRepository requestRepository, CoachService coachService) {
        this.requestRepository = requestRepository;
        this.coachService = coachService;
    }

    public RequestDto createRequest(RequestDto dto) {
        RequestEntity entity = toEntity(dto);

        requestRepository.save(entity);

        return fromEntity(entity);
    }

    public RequestDto fromEntity(RequestEntity entity) {
        if (entity == null) {
            return null;
        }

        return new RequestDto(
                entity.getId(),
                entity.getCoachId(),
                entity.getEmail(),
                entity.getMessage()
        );
    }

    public RequestEntity toEntity(RequestDto dto) {
        if (dto == null) {
            return null;
        }

        return new RequestEntity(
                dto.getId(),
                dto.getCoachId(),
                dto.getEmail(),
                dto.getMessage()
        );
    }
}

package com.andrewmcguiness.coachingappapi.service;

import com.andrewmcguiness.coachingappapi.domain.AreaEntity;
import com.andrewmcguiness.coachingappapi.domain.CoachEntity;
import com.andrewmcguiness.coachingappapi.dto.AreaDto;
import com.andrewmcguiness.coachingappapi.dto.CoachDto;
import com.andrewmcguiness.coachingappapi.repository.CoachRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CoachService {
    private final CoachRepository coachRepository;
    private final AreaService areaService;


    public CoachService(CoachRepository coachRepository, AreaService areaService) {
        this.coachRepository = coachRepository;
        this.areaService = areaService;
    }

    public List<CoachDto> getAllCoaches() {
        return coachRepository.findAll().stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    public CoachDto save(CoachDto dto) {
        CoachEntity entity = toEntity(dto);

        // Save Areas
        entity.setAreas(
                entity.getAreas().stream()
                        .map(areaService::createOrGetEntity)
                        .collect(Collectors.toSet())
        );

        return fromEntity(
                coachRepository.save(entity)
        );
    }


    public CoachEntity toEntity(CoachDto dto) {
        if (dto == null) {
            return null;
        }

        Set<AreaEntity> areas = dto.getAreas().stream()
                .map(areaService::toEntity)
                .collect(Collectors.toSet());

        return new CoachEntity(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getHourlyRate(),
                dto.getDescription(),
                areas
        );
    }

    public CoachDto fromEntity(CoachEntity entity) {
        if (entity == null) {
            return null;
        }

        Set<AreaDto> areas = entity.getAreas().stream()
                .map(areaService::fromEntity)
                .collect(Collectors.toSet());

        return new CoachDto(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getHourlyRate(),
                entity.getDescription(),
                areas
        );
    }

    public CoachDto getAllCoach(Long id) {
        return fromEntity(coachRepository.findById(id).orElse(null));
    }

    public void deleteById(Long id) {
        coachRepository.deleteById(id);
    }
}

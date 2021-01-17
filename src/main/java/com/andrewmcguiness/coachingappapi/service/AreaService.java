package com.andrewmcguiness.coachingappapi.service;


import com.andrewmcguiness.coachingappapi.domain.AreaEntity;
import com.andrewmcguiness.coachingappapi.dto.AreaDto;
import com.andrewmcguiness.coachingappapi.repository.AreaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AreaService {
    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public AreaEntity getEntityByName(String areaName) {
        return areaRepository.findByAreaName(areaName).orElse(null);
    }

    public AreaDto getByName(String areaName) {
        return fromEntity(getEntityByName(areaName));
    }

    public AreaDto getById(Long id) {
        return fromEntity(getEntityById(id));
    }

    public AreaEntity getEntityById(Long id) {
        return areaRepository.findById(id).orElse(null);
    }

    public AreaEntity createOrGetEntity(AreaEntity entity) {
        // Already have an id
        if (entity.getId() == null) {
            AreaEntity matches = getEntityByName(entity.getAreaName());
            if (matches != null) {
                entity = matches;
            } else {
                entity = areaRepository.save(entity);
            }
        }

        return entity;
    }

    public AreaDto fromEntity(AreaEntity entity) {
        if (entity == null) {
            return null;
        }

        return new AreaDto(
                entity.getId(),
                entity.getAreaName()
        );
    }

    public AreaEntity toEntity(AreaDto dto) {
        if (dto == null) {
            return null;
        }

        return new AreaEntity(
                dto.getId(),
                dto.getAreaName()
        );
    }
}

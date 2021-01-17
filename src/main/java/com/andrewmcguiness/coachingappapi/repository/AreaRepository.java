package com.andrewmcguiness.coachingappapi.repository;

import com.andrewmcguiness.coachingappapi.domain.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, Long> {
    Optional<AreaEntity> findByAreaName(String areaName);
}

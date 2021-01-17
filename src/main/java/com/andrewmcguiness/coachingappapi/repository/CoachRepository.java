package com.andrewmcguiness.coachingappapi.repository;


import com.andrewmcguiness.coachingappapi.domain.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<CoachEntity, Long> {
}

package com.andrewmcguiness.coachingappapi.repository;

import com.andrewmcguiness.coachingappapi.domain.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long> {
}

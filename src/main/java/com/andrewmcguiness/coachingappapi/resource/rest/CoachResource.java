package com.andrewmcguiness.coachingappapi.resource.rest;


import com.andrewmcguiness.coachingappapi.dto.CoachDto;
import com.andrewmcguiness.coachingappapi.resource.vm.CoachVm;
import com.andrewmcguiness.coachingappapi.service.CoachService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/coach")
@Validated
public class CoachResource {
    private final CoachService coachService;

    public CoachResource(CoachService coachService) {
        this.coachService = coachService;
    }

    @PostMapping
    public ResponseEntity<CoachVm> createCoach(@RequestBody @NotNull CoachVm coachVm) {
        CoachDto dto = CoachVm.toDto(coachVm);
        dto = coachService.save(dto);

        return ResponseEntity.ok(
                CoachVm.toVm(dto)
        );
    }

    @GetMapping
    public ResponseEntity<List<CoachVm>> getCoaches() {
        List<CoachDto> coachDtos = coachService.getAllCoaches();

        return ResponseEntity.ok(
                coachDtos.stream()
                        .map(CoachVm::toVm)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachVm> getCoachById(@PathVariable(name = "id") Long id) {
        CoachDto coachDto = coachService.getAllCoach(id);
        return ResponseEntity.ok(CoachVm.toVm(coachDto));
    }

    @DeleteMapping("/{id}")
    public void deleteCoachById(@PathVariable(name = "id") Long id) {
        coachService.deleteById(id);
    }
}

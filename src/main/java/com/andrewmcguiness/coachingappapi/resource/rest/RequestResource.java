package com.andrewmcguiness.coachingappapi.resource.rest;

import com.andrewmcguiness.coachingappapi.dto.RequestDto;
import com.andrewmcguiness.coachingappapi.resource.vm.RequestVm;
import com.andrewmcguiness.coachingappapi.service.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/request")
public class RequestResource {
    private final RequestService requestService;

    public RequestResource(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<RequestVm> createRequest(@RequestBody RequestVm vm) {
        RequestDto dto = RequestVm.toDto(vm);
        dto = requestService.createRequest(dto);
        return ResponseEntity.ok(RequestVm.toVm(dto));
    }
}

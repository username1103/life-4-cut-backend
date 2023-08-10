package com.onebyte.life4cut.sample.controller;

import com.onebyte.life4cut.sample.controller.dto.SampleCreateRequest;
import com.onebyte.life4cut.sample.controller.dto.SampleCreateResponse;
import com.onebyte.life4cut.sample.domain.SampleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/samples")
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @PostMapping
    public ResponseEntity<SampleCreateResponse> create(@Valid @RequestBody SampleCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new SampleCreateResponse(sampleService.createSample(request.getEmail(), request.nickname()))
        );
    }
}


package com.learningjourney.journey.abstractroutingdatasource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AbstractRoutingDataSourceApiController {
    private final AbstractRoutingDataSourceService service;
    @PostMapping("/student")
    public ResponseEntity<?> regStudent() {
        service.regStudent();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudentList() {
        return ResponseEntity.ok(service.getStudentList());
    }
}

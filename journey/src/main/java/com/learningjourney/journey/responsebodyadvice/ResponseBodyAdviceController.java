package com.learningjourney.journey.responsebodyadvice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/response-body-advice")
@RestController
public class ResponseBodyAdviceController {

    @GetMapping("/object-to-string")
    public ResponseEntity<CustomDto> object2String() {
        return ResponseEntity.ok(new CustomDto("SUCCESS"));
    }

    @GetMapping("/string-to-object")
    public String string2Object() {
        return "SUCCESS";
    }
}

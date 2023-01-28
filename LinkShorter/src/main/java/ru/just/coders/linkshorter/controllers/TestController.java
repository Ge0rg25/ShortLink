package ru.just.coders.linkshorter.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/hello")
    public ResponseEntity<?> test(){
        return new ResponseEntity<>("Hello Test",HttpStatus.OK);
    }
}

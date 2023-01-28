package ru.just.coders.linkshorter.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.just.coders.linkshorter.dto.LinkDtoAnonimous;
import ru.just.coders.linkshorter.services.LinkService;

import java.util.Map;

@RestController
public class RedirectController {

    private final LinkService linkService;

    public RedirectController(LinkService linkService){
        this.linkService = linkService;
    }


    @PostMapping("/")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<?> redirect(@RequestBody LinkDtoAnonimous dto){
        LinkDtoAnonimous linkDtoAnonimous = linkService.getLongUrl(dto);
        if (linkDtoAnonimous == null){
            return new ResponseEntity<>(Map.of("error", "url not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(linkDtoAnonimous, HttpStatus.OK);
    }

    @GetMapping("/test")
    @CrossOrigin(origins = "http://localhost:3000/")
    public String test(){
        return "test";
    }

}

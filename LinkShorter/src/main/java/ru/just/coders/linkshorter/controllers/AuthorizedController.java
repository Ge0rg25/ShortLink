package ru.just.coders.linkshorter.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.just.coders.linkshorter.dto.LinkDtoAuthorized;
import ru.just.coders.linkshorter.errors.LinkDoNotExistException;
import ru.just.coders.linkshorter.services.LinkService;

import java.util.Map;


@RestController
public class AuthorizedController {

    private final LinkService linkService;

    public AuthorizedController(LinkService linkService){
        this.linkService = linkService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createLink(@RequestBody LinkDtoAuthorized dtoAuthorized){
        return new ResponseEntity<>(linkService.addLink(dtoAuthorized), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteLink(@RequestBody LinkDtoAuthorized dtoAuthorized){
        return new ResponseEntity<>(Map.of("status", linkService.removeLink(dtoAuthorized)), HttpStatus.OK);
    }

    @PostMapping("/getlinks")
    public ResponseEntity<?> getlinks(@RequestBody LinkDtoAuthorized dtoAuthorized){
        return new ResponseEntity<>(linkService.getlinks(dtoAuthorized), HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleLinkDoNotExistsException(LinkDoNotExistException e){
        return new ResponseEntity<>(Map.of("error", "link do not exists"), HttpStatus.NOT_FOUND);
    }
}

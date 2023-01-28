package ru.just.coders.linkshorter.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.just.coders.linkshorter.dto.CheckDto;
import ru.just.coders.linkshorter.dto.LinkDtoAuthorized;
import ru.just.coders.linkshorter.errors.LinkDoNotExistException;
import ru.just.coders.linkshorter.feign.AuthCheck;
import ru.just.coders.linkshorter.services.LinkService;

import java.util.Map;


@RestController
public class AuthorizedController {

    private final AuthCheck authCheck;
    private final LinkService linkService;

    public AuthorizedController(LinkService linkService, AuthCheck authCheck){
        this.linkService = linkService;
        this.authCheck = authCheck;
    }


    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<?> createLink(@RequestBody LinkDtoAuthorized dtoAuthorized){
        CheckDto dto = authCheck.checkToken(Map.of("token", dtoAuthorized.getOwnertoken()));
        if (!dto.exists){
            return new ResponseEntity<>(Map.of("error", "invalid access token"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(linkService.addLink(dtoAuthorized), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<?> deleteLink(@RequestBody LinkDtoAuthorized dtoAuthorized){
        CheckDto dto = authCheck.checkToken(Map.of("token", dtoAuthorized.getOwnertoken()));
        if (!dto.exists){
            return new ResponseEntity<>(Map.of("error", "invalid access token"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(Map.of("status", linkService.removeLink(dtoAuthorized)), HttpStatus.OK);
    }

    @PostMapping("/getlinks")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<?> getlinks(@RequestBody LinkDtoAuthorized dtoAuthorized){
        CheckDto dto = authCheck.checkToken(Map.of("token", dtoAuthorized.getOwnertoken()));
        if (!dto.exists){
            return new ResponseEntity<>(Map.of("error", "invalid access token"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(linkService.getlinks(dtoAuthorized), HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleLinkDoNotExistsException(LinkDoNotExistException e){
        return new ResponseEntity<>(Map.of("error", "link do not exists"), HttpStatus.NOT_FOUND);
    }
}

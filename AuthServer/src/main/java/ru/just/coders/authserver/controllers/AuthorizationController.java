package ru.just.coders.authserver.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import ru.just.coders.authserver.dto.TokenDto;
import ru.just.coders.authserver.services.AuthorizationService;
import ru.just.coders.authserver.dto.UserDto;

import java.util.Map;

@RestController
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @Autowired
    public AuthorizationController(AuthorizationService authorizationService){
        this.authorizationService = authorizationService;
    }

    @PostMapping("/authorize")
    public ResponseEntity<?> authorize(@RequestBody UserDto model) {
        Map<String, String> token = authorizationService.getRedirectUrl(model.getEmail(), model.getPassword());

        if(token.get("error") != null) return ResponseEntity.status(401).body(token);

        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto model) {
        Map<String, String> token = authorizationService.registerNewUser(model);

        if(token.get("error") != null) return ResponseEntity.status(401).body(token);

        return ResponseEntity.ok(token);
    }

    @PostMapping("/userexists")
    public ResponseEntity<?> exists(@RequestBody TokenDto token) {
        return ResponseEntity.ok(authorizationService.tokenExists(token.getToken()));
    }

}

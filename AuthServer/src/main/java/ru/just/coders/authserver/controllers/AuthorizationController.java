package ru.just.coders.authserver.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import ru.just.coders.authserver.models.UserModel;
import ru.just.coders.authserver.services.AuthorizationService;

@RestController
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @Autowired
    public AuthorizationController(AuthorizationService authorizationService){
        this.authorizationService = authorizationService;
    }

    @PostMapping("/authorize")
    public RedirectView authorize(@RequestBody String email, @RequestBody String password) {
        return new RedirectView(authorizationService.getRedirectUrl(email, password));
    }

    @PostMapping("/register")
    public RedirectView register(@RequestBody String email, @RequestBody String password) {
        return new RedirectView(authorizationService.getRedirectUrl(email, password));
    }

}

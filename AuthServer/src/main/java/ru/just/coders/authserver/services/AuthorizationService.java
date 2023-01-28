package ru.just.coders.authserver.services;

import jakarta.transaction.Transactional;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.just.coders.authserver.dto.UserDto;
import ru.just.coders.authserver.models.UserModel;
import ru.just.coders.authserver.repositories.UserRepository;

import java.util.Map;
import java.util.Objects;


@Service
@Transactional
public class AuthorizationService {

    private final UserRepository userRepository;

    @Autowired
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel authorizeUser(String email, String password) {
        UserModel user = getUserByEmail(email);
        if(user == null) return null;
        if(!Objects.equals(user.getPasswd(), password)) return null;
        return user;
    }

    public Map<String, String> getRedirectUrl(String email, String password) {
        UserModel user = authorizeUser(email, password);
        if(user == null) return Map.of("error", "Invalid authorization data");
        return Map.of("token", user.getToken());
    }

    public Map<String, String> registerNewUser(UserDto model) {
        UserModel user = userRepository.findFirstByMail(model.getEmail());
        if(user != null) return Map.of("error", "User alerady exists");
        user = new UserModel();
        user.setPasswd(model.getPassword());
        user.setMail(model.getEmail());
        user.setToken(generateUserToken(model.getEmail(), model.getPassword()));

        userRepository.save(user);

        return Map.of("token", user.getToken());
    }

    public Map<String, Boolean> tokenExists(String token){
        return Map.of("exists", userRepository.existsByToken(token));
    }

    private String generateUserToken(String email, String password) {
        String sha256 = DigestUtils.sha256Hex(email+password);
        return sha256;
    }

    public UserModel getUserByEmail(String email) {
        return userRepository.findFirstByMail(email);
    };
}

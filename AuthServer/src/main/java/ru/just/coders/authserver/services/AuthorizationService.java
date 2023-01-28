package ru.just.coders.authserver.services;

import jakarta.transaction.Transactional;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.just.coders.authserver.models.UserModel;
import ru.just.coders.authserver.repositories.UserRepository;
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
        if(!Objects.equals(user.getPassword(), password)) return null;
        return user;
    }

    public String getRedirectUrl(String email, String password) {
        UserModel user = authorizeUser(email, password);
        if(user == null) return "http://localhost:4000/api/auth?error=notfound";
        return "http://localhost:4000/api/auth?token="+user.getToken();
    }

    public String registerNewUser(String email, String password) {
        UserModel user = userRepository.findAllByEmail(email);
        if(user != null) return "http://localhost:4000/api/register?error=userexist";
        user = new UserModel();
        user.setPassword(password);
        user.setEmail(email);
        user.setToken(generateUserToken(email, password));

        userRepository.save(user);

        return "http://localhost:4000/api/register?token="+user.getToken();
    }

    private String generateUserToken(String email, String password) {
        String sha256 = DigestUtils.sha256Hex(email+password);
        return sha256;
    }

    public UserModel getUserByEmail(String email) {
        return userRepository.findAllByEmail(email);
    };
}

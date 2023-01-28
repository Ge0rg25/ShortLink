package ru.just.coders.authserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.just.coders.authserver.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    public UserModel findAllByToken(String token);
    public UserModel findAllByEmail(String email);

}

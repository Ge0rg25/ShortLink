package ru.just.coders.authserver.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;

    @Column(name = "mail")
    String email;

    @Column(name = "psswd")
    String password;

    @Column(name = "tkn")
    String token;
}

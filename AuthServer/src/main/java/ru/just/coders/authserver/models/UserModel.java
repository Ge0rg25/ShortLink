package ru.just.coders.authserver.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "mail")
    String mail; 

    @Column(name = "psswd")
    String password;

    @Column(name = "tkn")
    String token;
}

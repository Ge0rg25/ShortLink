package ru.just.coders.linkshorter.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LINKS")
@Getter
@Setter
public class LinkModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "owner_token")
    private String owner_token;

    @Column(name = "short_url")
    private String short_url;

    @Column(name = "redirect_url")
    private String redirect_url;
}

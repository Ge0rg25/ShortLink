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
    long id;

    @Column(name = "ownertoken")
    String ownertoken;

    @Column(name = "shorturl")
    String shorturl;

    @Column(name = "redirecturl")
    String redirecturl;
}

package ru.just.coders.linkshorter.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkDtoAuthorized {

    String ownertoken;
    String redirecturl;

    String shorturl;
}

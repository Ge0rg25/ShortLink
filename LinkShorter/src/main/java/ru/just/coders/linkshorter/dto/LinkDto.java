package ru.just.coders.linkshorter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkDto {
    private String owner_token;

    private String redirect_url;

    private String short_url;

}

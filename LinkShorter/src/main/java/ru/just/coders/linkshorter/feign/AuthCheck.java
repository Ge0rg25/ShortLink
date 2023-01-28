package ru.just.coders.linkshorter.feign;


import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.PostMapping;
import ru.just.coders.linkshorter.dto.CheckDto;

import java.util.Map;


@FeignClient(value = "auth", url = "http://localhost:8082/auth")
public interface AuthCheck{

    @PostMapping("/userexists")
    public CheckDto checkToken(Map<String, String> json);

}

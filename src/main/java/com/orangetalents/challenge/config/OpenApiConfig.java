package com.orangetalents.challenge.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customConfiguration() {
        return new OpenAPI()
                .components(new Components())
                .info(getInfo());

    }

    private Info getInfo() {
        return new Info()
                .title("Orange Talents Stage 2")
                .description("Orange Talents technical test")
                .contact(getContact())
                .version("0.0.1");
    }

    private Contact getContact() {
        return new Contact()
                .name("Jeff Pereira")
                .url("https://www.linkedin.com/in/jeffmpereira/")
                .email("jeffmatheuspereira@gmail.com");
    }
}
package com.eventplanning.evento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI defineApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Event organiser Application");

        Info info = new Info().title("Event organiser API")
                              .version("1.0")
                              .description("Swagger testing phase");

        return new OpenAPI().addServersItem(server).info(info);
    }
}
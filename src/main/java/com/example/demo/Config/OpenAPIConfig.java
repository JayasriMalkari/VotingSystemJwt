package com.example.demo.Config;

import io.swagger.v3.oas.models.OpenAPI;
//import org.springframework.beans.factory.annotation.Value;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;

import java.util.List;

//@Configuration
//public class OpenAPIConfig {
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("VoteingSystem")
//                        .version("1.0")
//                        .description("API documentation for Spring Boot application"));
//    }

@Configuration
public class    OpenAPIConfig {

    @Value("${demo.openapi.dev-url}")
    private String defaultUrl;

    @Bean


    public OpenAPI myOpenAPI() {



        Server devServer = new Server();
        devServer.setUrl(defaultUrl);
        devServer.setDescription("Server URL in Development environment");

        Info info = new Info()
                .title("VotingSystem")
                .version("1.0");

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearer-jwt",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                )
                .addSecurityItem(new SecurityRequirement()
                        .addList("bearer-jwt"));
    }
    }


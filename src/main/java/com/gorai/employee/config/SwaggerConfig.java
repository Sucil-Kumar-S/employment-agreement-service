package com.gorai.employee.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employment Agreement Management API") // Title of the API
                        .description("API for managing employment agreements, including CRUD operations and search functionality.") // Brief overview
                        .version("1.0.0") // API version
                        .contact(new Contact()
                                .name("Sucil Kumar S") // Developer/maintainer name
                                .email("sucilkumar0709@gmail.com") // Developer/email
                                .url("https://github.com/Sucil-Kumar-S")) // Developer/organization website
                        .license(new License()
                                .name("MIT License") // License type
                                .url("https://opensource.org/licenses/MIT"))); // Link to license details
    }
}
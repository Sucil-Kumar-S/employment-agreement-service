package com.gorai.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers(
                    "/api/employment-agreements/**", // Allow all employment agreements APIs
                    "/h2-console/**"                 // Allow H2 Console
                ).permitAll() // Allow access to specified endpoints
                .anyRequest().authenticated() // Protect all other endpoints
            )
            .csrf().disable() // Disable CSRF for development/testing
            .headers().frameOptions().disable(); // Allow frames for H2 Console

        return http.build();
    }
}

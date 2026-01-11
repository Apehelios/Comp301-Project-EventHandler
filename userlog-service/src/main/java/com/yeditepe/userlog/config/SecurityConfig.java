package com.yeditepe.userlog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // ✅ /logs ve /logs/** tamamen açık
    @Bean
    @Order(1)
    public SecurityFilterChain logsChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/logs", "/logs/**")
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return http.build();
    }

    // ✅ diğer her şey (şimdilik) auth isteyebilir
    @Bean
    @Order(2)
    public SecurityFilterChain appChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )
                .headers(headers -> headers.frameOptions(frame -> frame.disable()));
        return http.build();
    }
}


package com.jobportal.articleservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final long MAX_AGE_SECS = 3600L;

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(new String[]{"*"})
                .allowedMethods(new String[]{"HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE"})
                .maxAge(3600L);
    }
}

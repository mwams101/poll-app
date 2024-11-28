package com.example.pollingapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow all origins
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")  // Allowed origins
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allowed methods
                .allowedHeaders("*")  // Allowed headers
                .allowCredentials(true);  // Allow credentials like cookies


    }
}
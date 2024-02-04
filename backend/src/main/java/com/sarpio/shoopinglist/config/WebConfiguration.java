package com.sarpio.shoopinglist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Piotr Sarnecki
 */
@EnableWebMvc
@Configuration
public class WebConfiguration {
    @Bean
    WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "DELETE")
                        .allowedHeaders(
                                HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,
                                HttpHeaders.CONTENT_TYPE)
                        .allowCredentials(false);
            }
        };
    }
}

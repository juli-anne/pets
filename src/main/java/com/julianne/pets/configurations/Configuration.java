package com.julianne.pets.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean // gives us access to the created rest template throughout the app
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

package com.julianne.pets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PetsApplication {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        SpringApplication.run(PetsApplication.class, args);
    }

}

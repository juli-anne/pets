package com.julianne.pets.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetPetsService {

    public ResponseEntity<String> gets() {
        return ResponseEntity.status(HttpStatus.OK).body("Here are the pets!");
    }
}

package com.julianne.pets.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdatePetService {

    public ResponseEntity<String> update() {
        return ResponseEntity.status(HttpStatus.OK).body("You updated a pet!");
    }
}

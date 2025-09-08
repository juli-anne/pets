package com.julianne.pets.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddPetService {

    public ResponseEntity<String> add() {
        return ResponseEntity.status(HttpStatus.CREATED).body("You added a new pet!");
    }
}

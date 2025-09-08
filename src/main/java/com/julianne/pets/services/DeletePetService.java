package com.julianne.pets.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeletePetService {

    public ResponseEntity<String> delete() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("You deleted a pet!");
    }
}

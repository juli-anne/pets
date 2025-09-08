package com.julianne.pets.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetPetService {

    public ResponseEntity<String> get() {
        return ResponseEntity.status(HttpStatus.OK).body("Here is the pet you are looking for!");
    }
}

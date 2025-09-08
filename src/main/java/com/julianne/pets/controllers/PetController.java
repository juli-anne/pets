package com.julianne.pets.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// CRUD - create(post), read (get), update (put), delete

@RestController
public class PetController {

    @PostMapping("/add")
    public ResponseEntity<String> addPet() {
        return ResponseEntity.status(HttpStatus.CREATED).body("You added a new pet!");
    }

    @GetMapping("/pets")
    public ResponseEntity<String> getPets() {
        return ResponseEntity.status(HttpStatus.OK).body("Here are the pets!");
    }

    @GetMapping("/pet")
    public ResponseEntity<String> getPet() {
        return ResponseEntity.status(HttpStatus.OK).body("Here is the pet you are looking for!");
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updatePet() {
        return ResponseEntity.status(HttpStatus.OK).body("You updated a pet!");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePet() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("You deleted a pet!");
    }
}

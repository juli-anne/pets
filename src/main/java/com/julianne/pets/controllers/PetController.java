package com.julianne.pets.controllers;

import com.julianne.pets.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// CRUD - create(post), read (get), update (put), delete

@RestController
public class PetController {

    // autowired - field injection - not recommended
    @Autowired
    private AddPetService addPetService;
    private final GetPetsService getPetsService;
    private final GetPetService getPetService;
    private final UpdatePetService updatePetService;
    private final DeletePetService deletePetService;

    public PetController(GetPetsService getPetsService, GetPetService getPetService, UpdatePetService updatePetService, DeletePetService deletePetService) {
        this.getPetsService = getPetsService;
        this.getPetService = getPetService;
        this.updatePetService = updatePetService;
        this.deletePetService = deletePetService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPet() {
        return addPetService.add();
    }

    @GetMapping("/pets")
    public ResponseEntity<String> getPets() {
        return getPetsService.gets();
    }

    @GetMapping("/pet")
    public ResponseEntity<String> getPet() {
        return getPetService.get();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updatePet() {
        return updatePetService.update();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePet() {
        return deletePetService.delete();
    }
}

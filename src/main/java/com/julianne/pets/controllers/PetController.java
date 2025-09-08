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
    private final AddPetService addPetService;
    private final GetPetsService getPetsService;
    private final GetPetService getPetService;
    private final UpdatePetService updatePetService;
    private final DeletePetService deletePetService;

    // constructor injection
    public PetController(GetPetsService getPetsService, GetPetService getPetService, UpdatePetService updatePetService, DeletePetService deletePetService, AddPetService addPetService) {
        this.getPetsService = getPetsService;
        this.getPetService = getPetService;
        this.updatePetService = updatePetService;
        this.deletePetService = deletePetService;
        this.addPetService = addPetService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPet() {
        return addPetService.execute(null);
    }

    @GetMapping("/pets")
    public ResponseEntity<String> getPets() {
        return getPetsService.execute(null);
    }

    @GetMapping("/pet")
    public ResponseEntity<String> getPet() {
        return getPetService.execute(null);
    }

    @PutMapping("update")
    public ResponseEntity<String> updatePet() {
        return updatePetService.execute(null);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deletePet() {
        return deletePetService.execute(null);
    }
}

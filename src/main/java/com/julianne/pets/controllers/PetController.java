package com.julianne.pets.controllers;

import com.julianne.pets.dtos.PetDTO;
import com.julianne.pets.entities.Pet;
import com.julianne.pets.services.*;
import com.julianne.pets.utils.UpdateProductCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// CRUD - create(post), read (get), update (put), delete
// controllers - listens for requests

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
    public ResponseEntity<PetDTO> addPet(@RequestBody Pet pet) {
        return addPetService.execute(pet);
    }

    @GetMapping("/pets")
    public ResponseEntity<List<PetDTO>> getPets() {
        return getPetsService.execute(null);
    }

    @GetMapping("/pet/{id}")
    public ResponseEntity<PetDTO> getPet(@PathVariable Integer id) {
        return getPetService.execute(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<PetDTO> updatePet(@PathVariable Integer id, @RequestBody Pet pet) {
        return updatePetService.execute(new UpdateProductCommand(id, pet));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Integer id) {
        return deletePetService.execute(id);
    }
}

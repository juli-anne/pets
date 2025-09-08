package com.julianne.pets.services;

import com.julianne.pets.dtos.PetDTO;
import com.julianne.pets.entities.Pet;
import com.julianne.pets.utils.Command;
import com.julianne.pets.repositories.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

// service - business logic
@Service
public class AddPetService implements Command<Pet, PetDTO> {

    private final PetRepository petRepository;

    public AddPetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public ResponseEntity<PetDTO> execute(Pet pet) {
        Pet savedPet = petRepository.save(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PetDTO(savedPet));
    }
}

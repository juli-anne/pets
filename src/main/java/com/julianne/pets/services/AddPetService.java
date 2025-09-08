package com.julianne.pets.services;

import com.julianne.pets.dtos.PetDTO;
import com.julianne.pets.entities.Pet;
import com.julianne.pets.exceptions.ErrorMessage;
import com.julianne.pets.exceptions.PetNotFoundException;
import com.julianne.pets.exceptions.PetNotValidException;
import com.julianne.pets.utils.Command;
import com.julianne.pets.repositories.PetRepository;
import com.julianne.pets.validators.PetValidator;
import io.micrometer.common.util.StringUtils;
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
        PetValidator.execute(pet);
        Pet savedPet = petRepository.save(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PetDTO(savedPet));
    }
}

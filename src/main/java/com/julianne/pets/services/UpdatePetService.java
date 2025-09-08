package com.julianne.pets.services;

import com.julianne.pets.dtos.PetDTO;
import com.julianne.pets.entities.Pet;
import com.julianne.pets.exceptions.PetNotFoundException;
import com.julianne.pets.repositories.PetRepository;
import com.julianne.pets.utils.Command;
import com.julianne.pets.utils.UpdateProductCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePetService implements Command<UpdateProductCommand, PetDTO> {

    private PetRepository petRepository;

    public UpdatePetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    @Override
    public ResponseEntity<PetDTO> execute(UpdateProductCommand  command) {
        Optional<Pet> optionalPet = petRepository.findById(command.getId());
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            pet.setId(command.getId());
            petRepository.save(pet);
            return ResponseEntity.ok(new PetDTO(pet));
        }
        throw new PetNotFoundException();
    }
}

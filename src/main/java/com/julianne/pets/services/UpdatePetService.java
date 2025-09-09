package com.julianne.pets.services;

import com.julianne.pets.dtos.PetDTO;
import com.julianne.pets.entities.Pet;
import com.julianne.pets.exceptions.PetNotFoundException;
import com.julianne.pets.repositories.PetRepository;
import com.julianne.pets.utils.Command;
import com.julianne.pets.utils.UpdatePetCommand;
import com.julianne.pets.validators.PetValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePetService implements Command<UpdatePetCommand, PetDTO> {

    private final PetRepository petRepository;

    public UpdatePetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    @Override
    public ResponseEntity<PetDTO> execute(UpdatePetCommand command) {
        Optional<Pet> optionalPet = petRepository.findById(command.getId());
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            pet.setId(command.getId());
            PetValidator.execute(pet);
            petRepository.save(pet);
            return ResponseEntity.ok(new PetDTO(pet));
        }
        throw new PetNotFoundException("Pet name not found");
    }
}

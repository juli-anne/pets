package com.julianne.pets.services;

import com.julianne.pets.dtos.PetDTO;
import com.julianne.pets.entities.Pet;
import com.julianne.pets.exceptions.PetNotFoundException;
import com.julianne.pets.repositories.PetRepository;
import com.julianne.pets.utils.Command;
import com.julianne.pets.utils.UpdatePetCommand;
import com.julianne.pets.validators.PetValidator;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
    @CachePut(value = "petCache", key="#command.getId()")
    // evict - throws it away
    // put - throws it away + puts the return value of the method in the cache
    public ResponseEntity<PetDTO> execute(UpdatePetCommand command) {
        Optional<Pet> optionalPet = petRepository.findById(command.getId());
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();

            Pet updatedPet = command.getPet();
            pet.setName(updatedPet.getName());
            pet.setType(updatedPet.getType());
            pet.setBreed(updatedPet.getBreed());
            pet.setAge(updatedPet.getAge());

            PetValidator.execute(pet);
            petRepository.save(pet);
            return ResponseEntity.ok(new PetDTO(pet));
        }
        throw new PetNotFoundException("Pet name not found" + command.getId());
    }
}

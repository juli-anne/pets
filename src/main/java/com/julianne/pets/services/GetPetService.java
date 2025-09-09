package com.julianne.pets.services;

import com.julianne.pets.dtos.PetDTO;
import com.julianne.pets.entities.Pet;
import com.julianne.pets.exceptions.PetNotFoundException;
import com.julianne.pets.utils.Query;
import com.julianne.pets.repositories.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPetService implements Query<Integer, PetDTO> {

    private final PetRepository petRepository;

    private static final Logger logger = LoggerFactory.getLogger(GetPetService.class);

    public GetPetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public ResponseEntity<PetDTO> execute(Integer id) {
        logger.info("Executing " + getClass() + " input: " + id);

        Optional <Pet> petOptional = petRepository.findById(id);
        if(petOptional.isPresent()) {
            return ResponseEntity.ok(new PetDTO(petOptional.get()));
        }
        throw new PetNotFoundException("Pet name not found");
    }
}

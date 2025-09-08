package com.julianne.pets.services;

import com.julianne.pets.dtos.PetDTO;
import com.julianne.pets.entities.Pet;
import com.julianne.pets.utils.Query;
import com.julianne.pets.repositories.PetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPetService implements Query<Integer, PetDTO> {

    private final PetRepository petRepository;

    public GetPetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public ResponseEntity<PetDTO> execute(Integer id) {
        Optional <Pet> petOptional = petRepository.findById(id);
        if(petOptional.isPresent()) {
            return ResponseEntity.ok(new PetDTO(petOptional.get()));
        }
        return null;
}
}

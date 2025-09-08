package com.julianne.pets.services;

import com.julianne.pets.dtos.PetDTO;
import com.julianne.pets.entities.Pet;
import com.julianne.pets.utils.Query;
import com.julianne.pets.repositories.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPetsService implements Query<Void, List<PetDTO>> {

    private final PetRepository petRepository;

    public GetPetsService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public ResponseEntity<List<PetDTO>> execute(Void input) {
        List<Pet> pets = petRepository.findAll();
        List<PetDTO> petsDTO = pets.stream().map(PetDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(petsDTO);
    }
}

package com.julianne.pets.services;

import com.julianne.pets.dtos.PetDTO;
import com.julianne.pets.repositories.PetRepository;
import com.julianne.pets.utils.Query;
import com.julianne.pets.utils.SearchCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchPetService implements Query<SearchCriteria, List<PetDTO>> {

    private final PetRepository petRepository;

    public SearchPetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public ResponseEntity<List<PetDTO>> execute(SearchCriteria criteria) {
        return switch (criteria.field().toLowerCase()) {
            case "name" -> ResponseEntity.ok(
                    petRepository.findByNameContaining(criteria.value())
                            .stream()
                            .map(PetDTO::new)
                            .toList()
            );
            case "type" -> ResponseEntity.ok(
                    petRepository.findByTypeContaining(criteria.value())
                            .stream()
                            .map(PetDTO::new)
                            .toList()
            );
            case "breed" -> ResponseEntity.ok(
                    petRepository.findByBreedContaining(criteria.value())
                            .stream()
                            .map(PetDTO::new)
                            .toList()
            );
            case "age" -> ResponseEntity.ok(
                    petRepository.findByAge(Integer.parseInt(criteria.value()))
                            .stream()
                            .map(PetDTO::new)
                            .toList()
            );
            default -> ResponseEntity.badRequest().build();
        };
    }
}

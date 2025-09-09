package com.julianne.pets.repositories;

import com.julianne.pets.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// repositories - how we make database calls
@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

    // spring data jpa
    List<Pet> findByNameContaining(String name);
    List<Pet> findByTypeContaining(String type);
    List<Pet> findByBreedContaining(String breed);
    List<Pet> findByAge(Integer age);
}

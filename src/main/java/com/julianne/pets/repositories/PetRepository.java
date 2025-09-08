package com.julianne.pets.repositories;

import com.julianne.pets.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// repositories - how we make database calls
@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
}

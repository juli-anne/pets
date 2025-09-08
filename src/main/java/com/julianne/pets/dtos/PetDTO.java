package com.julianne.pets.dtos;

import com.julianne.pets.entities.Pet;
import lombok.Data;

@Data
public class PetDTO {

    private Integer id;
    private String type;
    private String name;
    private String breed;
    private String age;

    public PetDTO(Pet pet) {
        this.id = pet.getId();
        this.type = pet.getType();
        this.name = pet.getName();
        this.breed = pet.getBreed();
        this.age = pet.getAge();
    }
}

package com.julianne.pets.utils;

import com.julianne.pets.entities.Pet;
import lombok.Getter;

@Getter
public class UpdatePetCommand {

    private Integer id;
    private Pet pet;

    public UpdatePetCommand(Integer id, Pet pet) {
        this.id = id;
        this.pet = pet;
    }
}

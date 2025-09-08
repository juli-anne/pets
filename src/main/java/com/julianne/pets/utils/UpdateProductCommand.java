package com.julianne.pets.utils;

import com.julianne.pets.entities.Pet;
import lombok.Getter;

@Getter
public class UpdateProductCommand {

    private Integer id;
    private Pet pet;

    public UpdateProductCommand(Integer id, Pet pet) {
        this.id = id;
        this.pet = pet;
    }
}

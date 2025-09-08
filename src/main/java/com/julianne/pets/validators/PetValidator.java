package com.julianne.pets.validators;

import com.julianne.pets.entities.Pet;
import com.julianne.pets.exceptions.ErrorMessage;
import com.julianne.pets.exceptions.PetNotFoundException;
import com.julianne.pets.exceptions.PetNotValidException;
import io.micrometer.common.util.StringUtils;

public class PetValidator {

    private PetValidator() {

    }

    public static void execute(Pet pet) {
        if(StringUtils.isEmpty(pet.getName())) {
            throw new PetNotFoundException(ErrorMessage.NAME_REQUIRED.getMessage());
        }
        if (StringUtils.isEmpty(pet.getType())) {
            throw new PetNotValidException(ErrorMessage.TYPE_REQUIRED.getMessage());
        }
        if (StringUtils.isEmpty(pet.getBreed())) {
            throw new PetNotValidException(ErrorMessage.BREED_REQUIRED.getMessage());
        }
        if (pet.getAge() == null || pet.getAge() <= 0) {
            throw new PetNotValidException(ErrorMessage.AGE_REQUIRED.getMessage());
        }
    }
}

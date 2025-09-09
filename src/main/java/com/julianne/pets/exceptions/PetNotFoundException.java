package com.julianne.pets.exceptions;

import com.julianne.pets.services.GetPetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PetNotFoundException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(PetNotFoundException.class);

    public PetNotFoundException(String petNotFoundException) {
        super(ErrorMessage.PET_NOT_FOUND.getMessage());
        logger.error("Exception {} thrown.", getClass());
    }
}

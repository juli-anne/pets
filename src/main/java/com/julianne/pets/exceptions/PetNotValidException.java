package com.julianne.pets.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PetNotValidException extends RuntimeException {

    public PetNotValidException(String message) {
        super(message);
    }
}

package com.julianne.pets.exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    PET_NOT_FOUND("Pet Not Found!");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

}

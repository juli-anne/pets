package com.julianne.pets.exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    PET_NOT_FOUND("Pet Not Found!"),
    NAME_REQUIRED("Name The Pet!"),
    TYPE_REQUIRED("Animal Type Required!"),
    BREED_REQUIRED("Animal Breed Required!"),
    AGE_REQUIRED("Age is required and can't be negative!");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}

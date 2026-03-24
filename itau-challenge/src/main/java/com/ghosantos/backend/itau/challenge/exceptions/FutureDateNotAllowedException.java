package com.ghosantos.backend.itau.challenge.exceptions;

public class FutureDateNotAllowedException extends RuntimeException {
    public FutureDateNotAllowedException(String message) {
        super(message);
    }
}

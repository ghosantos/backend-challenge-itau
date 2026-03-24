package com.ghosantos.backend.itau.challenge.exceptions;

public class PastDateNotAllowedException extends RuntimeException {
    public PastDateNotAllowedException(String message) {
        super(message);
    }
}

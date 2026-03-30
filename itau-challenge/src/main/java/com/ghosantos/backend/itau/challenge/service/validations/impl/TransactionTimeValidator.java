package com.ghosantos.backend.itau.challenge.service.validations.impl;

import com.ghosantos.backend.itau.challenge.dto.TransactionRequest;
import com.ghosantos.backend.itau.challenge.exceptions.PastDateNotAllowedException;
import com.ghosantos.backend.itau.challenge.service.validations.Validation;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Instant;

@Component
public class TransactionTimeValidator implements Validation {

    private final Clock clock;

    public TransactionTimeValidator(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void validate(TransactionRequest request) {
        Instant allowedLimit = clock.instant().minusSeconds(60);

        if (request.dateTime().toInstant().isBefore(allowedLimit)){
            throw new PastDateNotAllowedException("Transação fora do intervalo de 60 segundos");
        }
    }
}

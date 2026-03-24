package com.ghosantos.backend.itau.challenge.service.validations.impl;

import com.ghosantos.backend.itau.challenge.dto.TransactionRequest;
import com.ghosantos.backend.itau.challenge.exceptions.PastDateNotAllowedException;
import com.ghosantos.backend.itau.challenge.service.validations.Validation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.OffsetDateTime;

@Component
@Order(3)
public class PastDateValidator implements Validation {

    private final Clock clock;

    public PastDateValidator(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void validate(TransactionRequest request) {
        if (request.dateTime().isBefore(OffsetDateTime.now())){
            throw new PastDateNotAllowedException("Data/hora da transação não deve ser anterior a atual");
        }
    }
}

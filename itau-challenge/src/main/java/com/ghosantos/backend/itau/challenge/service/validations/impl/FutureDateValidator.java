package com.ghosantos.backend.itau.challenge.service.validations.impl;

import com.ghosantos.backend.itau.challenge.dto.TransactionRequest;
import com.ghosantos.backend.itau.challenge.exceptions.FutureDateNotAllowedException;
import com.ghosantos.backend.itau.challenge.service.validations.Validation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Clock;

@Component
@Order(4)
public class FutureDateValidator implements Validation {

    private final Clock clock;

    public FutureDateValidator(Clock clock) {
        this.clock = clock;
    }

    @Override
    public final void validate(TransactionRequest request) {
        if (request.dateTime().toInstant().isAfter(clock.instant())){
            throw new FutureDateNotAllowedException("Data/hora da transação não deve ser posterior a atual");
        }
    }
}

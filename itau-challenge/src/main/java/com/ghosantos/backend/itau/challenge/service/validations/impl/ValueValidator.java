package com.ghosantos.backend.itau.challenge.service.validations.impl;

import com.ghosantos.backend.itau.challenge.dto.TransactionRequest;
import com.ghosantos.backend.itau.challenge.exceptions.InvalidValueException;
import com.ghosantos.backend.itau.challenge.service.validations.Validation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class ValueValidator implements Validation {
    @Override
    public void validate(TransactionRequest request) {
        if (request.value() < 0){
            throw new InvalidValueException("O valor não deve ser negativo.");
        }
    }
}

package com.ghosantos.backend.itau.challenge.service.validations.impl;

import com.ghosantos.backend.itau.challenge.dto.TransactionRequest;
import com.ghosantos.backend.itau.challenge.exceptions.UnfilledFieldsException;
import com.ghosantos.backend.itau.challenge.service.validations.Validation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class RequiredFieldsValidator implements Validation {

    @Override
    public void validate(TransactionRequest request){
        if (request.value() == null || request.dateTime() == null){
            throw new UnfilledFieldsException("Campos obrigatórios não foram preenchidos: valor, data/hora");
        }
    }

}

package com.ghosantos.backend.itau.challenge.service.validations;

import com.ghosantos.backend.itau.challenge.dto.TransactionRequest;

public interface Validation {
    void validate(TransactionRequest request);
}

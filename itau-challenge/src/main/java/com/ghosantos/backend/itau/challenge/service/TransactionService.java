package com.ghosantos.backend.itau.challenge.service;

import com.ghosantos.backend.itau.challenge.domain.Transaction;
import com.ghosantos.backend.itau.challenge.dto.TransactionRequest;
import com.ghosantos.backend.itau.challenge.service.validations.Validation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();
    private final List<Validation> validations;

    public TransactionService(List<Validation> validations) {
        this.validations = validations;
    }

    public void save(TransactionRequest request){
        validations.forEach(v -> v.validate(request));
        transactions.add(new Transaction(request.value(), request.dateTime()));
    }

    public void delete(){
        transactions.clear();
    }
}

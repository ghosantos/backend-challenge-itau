package com.ghosantos.backend.itau.challenge.service;

import com.ghosantos.backend.itau.challenge.domain.Transaction;
import com.ghosantos.backend.itau.challenge.service.validations.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @InjectMocks
    public TransactionService service;

    @Test
    public void buscar(){
        Transaction t = new Transaction(10.00, OffsetDateTime.now());
        Transaction t1 = new Transaction(10.00, OffsetDateTime.now());
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(t);
        transactions.add(t1);

        Assertions.assertEquals(1, transactions.size());
    }
}
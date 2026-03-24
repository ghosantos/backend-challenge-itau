package com.ghosantos.backend.itau.challenge.controller;

import com.ghosantos.backend.itau.challenge.dto.TransactionRequest;
import com.ghosantos.backend.itau.challenge.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "transaction")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public void save(@RequestBody TransactionRequest request){
        transactionService.save(request);
    }
}

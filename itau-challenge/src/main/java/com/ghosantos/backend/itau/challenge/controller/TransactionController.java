package com.ghosantos.backend.itau.challenge.controller;

import com.ghosantos.backend.itau.challenge.dto.StatisticsResponse;
import com.ghosantos.backend.itau.challenge.dto.TransactionRequest;
import com.ghosantos.backend.itau.challenge.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "transaction")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> save (@RequestBody TransactionRequest request){
        transactionService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(){
        transactionService.delete();
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/statistics")
    public ResponseEntity<StatisticsResponse> getStats(){
        StatisticsResponse response = transactionService.getStatistics();
        return ResponseEntity.ok().body(response);
    }
}

package com.ghosantos.backend.itau.challenge.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.OffsetDateTime;

public record TransactionRequest(

        @NotNull(message = "Campos obrigatórios não foram preenchidos: value")
        @Positive(message = "O valor deve ser maior que zero")
        Double value,

        @NotNull(message = "Campos obrigatórios não foram preenchidos: dateTime")
        @PastOrPresent(message = "A data não pode ser no futuro")
        OffsetDateTime dateTime
) { }

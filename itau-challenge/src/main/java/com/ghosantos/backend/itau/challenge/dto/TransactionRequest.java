package com.ghosantos.backend.itau.challenge.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;

public record TransactionRequest(Double value, OffsetDateTime dateTime) implements Serializable {
}

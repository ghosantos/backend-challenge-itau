package com.ghosantos.backend.itau.challenge.domain;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class Transaction implements Serializable {

    private Double value;
    private OffsetDateTime dateTime;

    public Transaction(Double value, OffsetDateTime dateTime) {
        this.value = value;
        this.dateTime = dateTime;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

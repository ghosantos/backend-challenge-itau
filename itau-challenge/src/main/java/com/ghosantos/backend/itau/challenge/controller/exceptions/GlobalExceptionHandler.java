package com.ghosantos.backend.itau.challenge.controller.exceptions;

import com.ghosantos.backend.itau.challenge.exceptions.FutureDateNotAllowedException;
import com.ghosantos.backend.itau.challenge.exceptions.PastDateNotAllowedException;
import com.ghosantos.backend.itau.challenge.exceptions.UnfilledFieldsException;
import com.ghosantos.backend.itau.challenge.exceptions.InvalidValueException;

import org.springframework.http.HttpStatus;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FutureDateNotAllowedException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void handlerDateHourPosteriors(FutureDateNotAllowedException e) {
    }

    @ExceptionHandler(PastDateNotAllowedException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void handlerDateHourPrevious(PastDateNotAllowedException e) {
    }

    @ExceptionHandler(UnfilledFieldsException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void handlerUnfilledFields(UnfilledFieldsException e) {
    }

    @ExceptionHandler(InvalidValueException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void handlerValueInvalid(InvalidValueException e) {
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handlerMessageNotReadable(HttpMessageNotReadableException e){
    }
}

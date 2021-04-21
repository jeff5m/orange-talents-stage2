package com.orangetalents.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ZipCodeValidationException extends RuntimeException {
    public ZipCodeValidationException(String message) {
        super(message);
    }
}

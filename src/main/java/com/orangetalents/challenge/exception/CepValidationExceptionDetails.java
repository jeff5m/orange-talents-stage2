package com.orangetalents.challenge.exception;

import java.time.LocalDateTime;

public class CepValidationExceptionDetails extends ExceptionDetails{
    public CepValidationExceptionDetails(String title, int status, String details, LocalDateTime timestamp) {
        super(title, status, details, timestamp);
    }
}

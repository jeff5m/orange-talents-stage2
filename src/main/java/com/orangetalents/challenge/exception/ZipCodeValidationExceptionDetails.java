package com.orangetalents.challenge.exception;

import java.time.LocalDateTime;

public class ZipCodeValidationExceptionDetails extends ExceptionDetails {
    public ZipCodeValidationExceptionDetails(String title, int status, String details, LocalDateTime timestamp) {
        super(title, status, details, timestamp);
    }
}

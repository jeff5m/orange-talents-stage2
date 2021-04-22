package com.orangetalents.challenge.exception;

import java.time.LocalDateTime;

public class ResourceNotFoundExceptionDetails extends ExceptionDetails {
    public ResourceNotFoundExceptionDetails(String title, int status, String details, LocalDateTime timestamp) {
        super(title, status, details, timestamp);
    }
}

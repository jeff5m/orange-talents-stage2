package com.orangetalents.challenge.exception;

import java.time.LocalDateTime;

public class ExceptionDetails {
    private final String title;
    private final int status;
    private final String details;
    private final LocalDateTime timestamp;

    public ExceptionDetails(String title, int status, String details, LocalDateTime timestamp) {
        this.title = title;
        this.status = status;
        this.details = details;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

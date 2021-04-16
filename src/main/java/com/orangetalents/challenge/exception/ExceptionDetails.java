package com.orangetalents.challenge.exception;

import java.time.LocalDateTime;

public class ExceptionDetails {
    private final String title;
    private final int status;
    private final String details;
    private final LocalDateTime timestamp;
    private final String fields;
    private final String fieldsMessage;

    public ExceptionDetails(String title, int status, String details, LocalDateTime timestamp, String fields, String fieldsMessage) {
        this.title = title;
        this.status = status;
        this.details = details;
        this.timestamp = timestamp;
        this.fields = fields;
        this.fieldsMessage = fieldsMessage;
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

    public String getFields() {
        return fields;
    }

    public String getFieldsMessage() {
        return fieldsMessage;
    }
}

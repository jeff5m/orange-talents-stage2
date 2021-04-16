package com.orangetalents.challenge.exception;

import java.time.LocalDateTime;

public class ValidationExceptionDetails extends ExceptionDetails {
    private final String fields;
    private final String fieldsMessage;

    public ValidationExceptionDetails(String title, int status, String details, LocalDateTime timestamp, String fields, String fieldsMessage) {
        super(title, status, details, timestamp);
        this.fields = fields;
        this.fieldsMessage = fieldsMessage;
    }

    public String getFields() {
        return fields;
    }

    public String getFieldsMessage() {
        return fieldsMessage;
    }
}

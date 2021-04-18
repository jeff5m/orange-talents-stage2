package com.orangetalents.challenge.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        return new ResponseEntity<>(new ExceptionDetails(
                "Resource Not Found Exception, the resource could not be found",
                HttpStatus.NOT_FOUND.value(),
                resourceNotFoundException.getMessage(),
                LocalDateTime.now()), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(CepValidationException.class)
    public ResponseEntity<CepValidationExceptionDetails> handleCepValidationException(CepValidationException cepValidationException) {
        return new ResponseEntity<>(new CepValidationExceptionDetails(
                "Cep Validation Exception, Address information is not valid",
                HttpStatus.BAD_REQUEST.value(),
                cepValidationException.getMessage(),
                LocalDateTime.now()), HttpStatus.BAD_REQUEST
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(new ValidationExceptionDetails(
                "Bad Request Exception, Invalid Fields",
                HttpStatus.BAD_REQUEST.value(),
                "Check field(s) error",
                LocalDateTime.now(),
                fields,
                fieldsMessage), HttpStatus.BAD_REQUEST
        );
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception exception, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(
                exception.getClass().getName(),
                status.value(),
                exception.getMessage(),
                LocalDateTime.now());

        return new ResponseEntity<>(exceptionDetails, headers, status);
    }
}

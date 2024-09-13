package org.spring.start.restservices.advice;

import org.spring.start.restservices.model.ErrorDetails;
import org.spring.start.restservices.service.NotEnoughMoneyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(NotEnoughMoneyException e) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not Enough Money to make payments " + e.getMessage());
        return ResponseEntity.badRequest().body(errorDetails);
    }
}

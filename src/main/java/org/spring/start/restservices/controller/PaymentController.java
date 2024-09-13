package org.spring.start.restservices.controller;

import org.spring.start.restservices.model.ErrorDetails;
import org.spring.start.restservices.model.PaymentDetails;
import org.spring.start.restservices.service.NotEnoughMoneyException;
import org.spring.start.restservices.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try{
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        } catch (NotEnoughMoneyException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money in your account");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }
}

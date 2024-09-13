package org.spring.start.restservices.controller;

import org.spring.start.restservices.model.PaymentDetails;
import org.spring.start.restservices.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {
    private static Logger logger = Logger.getLogger(PaymentController.class.getName());
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(@RequestBody PaymentDetails paymentDetails) {

            logger.info("Received payment " + paymentDetails.getAmount());
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);

    }
}

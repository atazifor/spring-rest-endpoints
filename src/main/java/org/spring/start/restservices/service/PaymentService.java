package org.spring.start.restservices.service;

import org.spring.start.restservices.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}

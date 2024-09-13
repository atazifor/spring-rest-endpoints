package org.spring.start.restservices.service;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException() {

    }
    public NotEnoughMoneyException(String from_payment_service) {
    }
}

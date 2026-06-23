package com.amigoscode._3_oop._4_polymorphism;

import java.util.ArrayList;
import java.util.List;

class PaymentDemo {
    public static void main(String[] args) {

        List<Payment> payments = new ArrayList<>();
        payments.add(new CreditCardPayment("55155515"));
        payments.add(new PayPalPayment("paypal@gmail.com"));
        payments.add(new BankTransferPayment("mineBankId122"));

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processAllPayments(payments, 10.15);

        Payment payment = new CreditCardPayment("1234-5678");
        payment.processPayment(100.0);
        payment = new PayPalPayment("user@email.com");
        payment.processPayment(200.0);
        payment = new BankTransferPayment("bankId123");
        payment.processPayment(300.0);

    }
}

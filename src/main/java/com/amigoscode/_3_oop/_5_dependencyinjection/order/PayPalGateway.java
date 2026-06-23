package com.amigoscode._3_oop._5_dependencyinjection.order;

public class PayPalGateway implements PaymentGateway {

    @Override
    public boolean charge(double amount) {
        System.out.println("[PayPal] Charging $" + amount);
        return true;
    }
}

package com.amigoscode._3_oop._5_dependencyinjection.order;

public class StripeGateway implements PaymentGateway {

    @Override
    public boolean charge(double amount) {
        System.out.println("[Stripe] Charging $" + amount);
        return true;
    }
}

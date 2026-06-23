package com.amigoscode._3_oop._5_dependencyinjection.order;

public interface PaymentGateway {
    boolean charge(double amount);
}

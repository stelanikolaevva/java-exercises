package com.amigoscode._3_oop._4_polymorphism;

//   Create a PayPalPayment class that implements Payment.
//   - Add a private field: email (String)
//   - Create a constructor that takes the email
//   - Implement processPayment() to print:
//     "Processing PayPal payment of $<amount> from <email>"
//     and return true
//   - Implement getPaymentMethod() to return "PayPal"

public class PayPalPayment implements Payment {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.printf("Processing PayPal payment of $%.2f from %s%n", amount, this.email);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}

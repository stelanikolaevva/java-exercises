package com.amigoscode._3_oop._4_polymorphism;

// Create a CreditCardPayment class that implements Payment.
//   - Add a private field: cardNumber (String)
//   - Create a constructor that takes the cardNumber
//   - Implement processPayment() to print:
//     "Processing credit card payment of $<amount> with card <cardNumber>"
//     and return true
//   - Implement getPaymentMethod() to return "Credit Card"
public class CreditCardPayment implements Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.printf("Processing credit card payment of $%.2f with card %s%n", amount, this.cardNumber);
        return false;
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}

package com.amigoscode._3_oop._4_polymorphism;

//  Create a PaymentProcessor class with a method:
//   void processAllPayments(List<Payment> payments, double amount)
//   Iterate over the list and call processPayment(amount) on each.
//   After each payment, call printReceipt(amount).

import java.util.List;

public class PaymentProcessor {
    public void processAllPayments(List<Payment> payments, double amount) {
        for (Payment payment : payments) {
            payment.processPayment(amount);
            payment.printReceipt(amount);
        }
    }
}

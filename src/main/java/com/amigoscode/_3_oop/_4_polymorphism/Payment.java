package com.amigoscode._3_oop._4_polymorphism;

//  Create a Payment interface with:
//   - A method: boolean processPayment(double amount)
//   - A method: String getPaymentMethod()
//   - A default method: void printReceipt(double amount) that prints:
//     "Receipt: $<amount> paid via <getPaymentMethod()>"
//     Default methods provide a body in the interface itself.
public interface Payment {
    boolean processPayment(double amount);

    String getPaymentMethod();

    default void printReceipt(double amount) {
        System.out.println("Receipt: $" + amount + " paid via " + getPaymentMethod());
    }
}

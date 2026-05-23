package com.amigoscode._2_developers._10_exceptions;

/**
 * Custom Exception Exercises
 *
 * Practice creating custom checked and unchecked exceptions, throwing them
 * from methods, catching them, and using exception chaining.
 */
public class CustomException {

    static void main(String[] args) {
        System.out.println("=== Custom Checked Exception (InsufficientFundsException) ===");

        BankAccount bankAccount = new BankAccount(100);
        try {
            bankAccount.withdraw(50);
            System.out.println("Remaining balance: " + bankAccount.getBalance());
            bankAccount.withdraw(75);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Missing amount: " + e.getAmount());
        }

        try {
            validateAge(25);
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\n=== Exception Chaining ===");
        try {
            try {
                validateAge(Integer.parseInt("abc"));
            } catch (NumberFormatException e) {
                throw new InvalidAgeException("Invalid number", e);
            }
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause().getMessage());
        }

    }

    private static class BankAccount {

        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        double getBalance() {
            return balance;
        }

        void withdraw(double amount) throws InsufficientFundsException {
            if (amount > balance) {
                throw new InsufficientFundsException("Insufficient funds in the bank account.", amount - balance);
            }
            balance -= amount;
        }
    }

    private static void validateAge(int age) {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Age " + age + " is invalid.");
        }
        System.out.println("Age " + age + " is valid.");
    }

    private static class InvalidAgeException extends RuntimeException {

        public InvalidAgeException(String message) {
            super(message);
        }

        public InvalidAgeException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}


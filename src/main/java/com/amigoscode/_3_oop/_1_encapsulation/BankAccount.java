package com.amigoscode._3_oop._1_encapsulation;

/**
 * Exercise: Encapsulation with BankAccount
 * <p>
 * Learn how to protect data using private fields, provide controlled access
 * through getters, and enforce business rules in methods.
 * <p>
 * Key concepts:
 * - Private fields to hide internal state
 * - Public methods to provide controlled access
 * - Validation logic inside setters/methods
 * - Private helper methods
 */
public class BankAccount {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // TODO: 4 - Create a deposit(double amount) method.
    //   - If amount <= 0, throw IllegalArgumentException with message
    //     "Deposit amount must be positive"
    //   - Add amount to balance
    //   - Call the private logTransaction() helper with a descriptive message
    //   - Return the new balance

    public double deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive!");
        }

        logTransaction("Deposited: " + amount);
        this.balance += amount;

        return this.balance;
    }

    public double withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive!");
        } else if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds!");
        }
        logTransaction("Withdrawn: " + amount);
        this.balance -= amount;

        return this.balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }

    private void logTransaction(String message) {
        System.out.println("[Transaction Log] " + message);
    }

    public static void main(String[] args) {
        // Uncomment and test after completing the TODOs:
        BankAccount account = new BankAccount("ACC-001", "Alice", 1000.0);
        System.out.println(account);
        System.out.println("Balance: " + account.getBalance());

        account.deposit(500.0);
        System.out.println("After deposit: " + account.getBalance());

        account.withdraw(200.0);
        System.out.println("After withdrawal: " + account.getBalance());

        //These should throw exceptions:
        account.deposit(-100);
        account.withdraw(999999);
    }
}

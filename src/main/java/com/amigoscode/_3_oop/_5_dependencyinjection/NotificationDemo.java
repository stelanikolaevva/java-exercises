package com.amigoscode._3_oop._5_dependencyinjection;

/**
 * Exercise: Dependency Injection - Notification Service
 * <p>
 * Build a notification system where the NotificationService does NOT
 * create its own dependencies. Instead, it receives them through its
 * constructor (constructor injection). This makes the code flexible,
 * testable, and follows the Dependency Inversion Principle.
 * <p>
 * Key concepts:
 * - Defining an interface for the dependency
 * - Constructor injection (passing dependencies via constructor)
 * - Swapping implementations without changing the dependent class
 * - Programming to an interface
 */


class NotificationDemo {
    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();
        NotificationService emailNotification = new NotificationService(emailSender);
        emailNotification.sendNotification("alice@example.com", "Hello via email!");

        SmsSender smsSender = new SmsSender();
        NotificationService smsNotification = new NotificationService(smsSender);
        smsNotification.sendNotification("+1234567890", "Hello via SMS!");


        MessageSender messageSender = emailSender;
        NotificationService messageNotification = new NotificationService(messageSender);
        messageNotification.sendNotification("me@example.com", "I am email");
        messageSender = smsSender;
        messageNotification = new NotificationService(messageSender);
        messageNotification.sendNotification("+123123123123", "I am an SMS");


    }
}

package com.amigoscode._3_oop._5_dependencyinjection;

public class NotificationService {
    private final MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendNotification(String to, String message) {
        messageSender.send(to, message);
    }
}

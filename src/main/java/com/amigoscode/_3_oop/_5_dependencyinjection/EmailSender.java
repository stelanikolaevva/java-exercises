package com.amigoscode._3_oop._5_dependencyinjection;

public class EmailSender implements MessageSender {

    @Override
    public void send(String to, String message) {
        System.out.println("[Email] Sending to " + to + ": " + message);
    }
}

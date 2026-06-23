package com.amigoscode._3_oop._6_solid.todo1;

public class UserValidator {
    public void validate(String name, String email) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Invalid name");
        if (!email.contains("@")) throw new IllegalArgumentException("Invalid email");
    }
}

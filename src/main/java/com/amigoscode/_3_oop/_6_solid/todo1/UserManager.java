package com.amigoscode._3_oop._6_solid.todo1;

public class UserManager {
    private UserRepository userRepository;
    private UserNotifier userNotifier;
    private UserValidator userValidator;

    public UserManager(UserRepository userRepository, UserNotifier userNotifier, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userNotifier = userNotifier;
        this.userValidator = userValidator;
    }

    public void createUser(String name, String email) {
        userValidator.validate(name, email);
        userRepository.save(name, email);
        userNotifier.sendWelcome(email);
    }
}

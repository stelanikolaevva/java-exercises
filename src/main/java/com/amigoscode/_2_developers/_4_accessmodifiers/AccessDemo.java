package com.amigoscode._2_developers._4_accessmodifiers;

/**
 * Access Modifiers Demo
 *
 * Demonstrates how different access modifiers behave when accessing members
 * from another class in the SAME package. Complete the AccessModifiers class first.
 */
public class AccessDemo {

    static void main(String[] args) {
        AccessModifiers accessModifiers = new AccessModifiers();

        System.out.println("=== Calling Public Method ===");
        System.out.println(accessModifiers.publicGreeting());

        System.out.println("\n=== Calling Package-Private Method ===");
        System.out.println(accessModifiers.packageGreeting());

        System.out.println("\n=== Accessing Private Field Through Getter ===");
        accessModifiers.setSecret("Top-Sercret Value");
        System.out.println(accessModifiers.getSecret());

        System.out.println("\n=== Why Direct Private Access Won't Work ===");
        //accessModifiers.secret = "trying direct access";

        // Private access modifier means that the property would not be accessed outside the class where is it declared
        // We can only access is it though its getter and setter


    }
}

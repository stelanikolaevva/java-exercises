package com.amigoscode._2_developers._5_methods;

/**
 * Method Overloading Exercises
 *
 * Practice creating overloaded methods — multiple methods with the same name
 * but different parameter lists. Java determines which version to call based
 * on the arguments you pass.
 */
public class MethodOverloading {

    private static int add(int a, int b) {
        return a + b;
    }

    private static int add(int a, int b, int c) {
        return a + b + c;
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static String format(String value) {
        return String.format("[%s]", value);
    }

    private static String format(int value) {
        return String.format("[%05d]", value);
    }

    private static String format(String label, int value) {
        return String.format("\"%s\": %d", label, value);
    }

    static void main(String[] args) {

        System.out.println("Addition of 2 + 3 is " + add(2, 3));
        System.out.println("Addition of 1 + 2 + 3 is " + add(1, 2, 3));
        System.out.println("Addition of 1.5 + 2.5 is " + add(1.5, 2.5));

        System.out.println("String formated in square brackets: " + format("hello"));
        System.out.println("Integer formatted with leading zeros to 5 digits: " + format(42));
        System.out.println("String formated: " + format("Score", 95));

    }
}

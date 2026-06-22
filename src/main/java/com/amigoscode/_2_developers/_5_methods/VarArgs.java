package com.amigoscode._2_developers._5_methods;

import java.util.Arrays;
/**
 * Variable Arguments (Varargs) Exercises
 *
 * Practice using the varargs syntax (Type... name) which allows methods to accept
 * zero or more arguments of the same type. Internally, varargs are treated as arrays.
 */
public class VarArgs {

    private static int sum(int... numbers) {
        if (numbers == null) {
            return 0;
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }


    private static String concatenate(String... strings) {
        if (strings == null) {
            return "";
        }
        return String.join(" ", strings);
    }

    private static int findMax(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("At least one number required.");
        }
        return Arrays.stream(numbers).max().orElse(Integer.MIN_VALUE);
    }

    private static void printAll(Object... objects) {
        if (objects == null || objects.length == 0) {
            throw new IllegalArgumentException("At least one object required.");
        }
        for (int i = 0; i < objects.length; i++) {
            System.out.println("[" + i + "] " + objects[i]);
        }
    }

    private static String format(String prefix, int... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("At least one number required.");
        }
        return prefix + ": " + Arrays.toString(numbers);

    }

    static void main(String[] args) {

        System.out.println("=== Sum ===");
        System.out.println("Sum when we have no args: " + sum());
        System.out.println("Sum when we have 5 as single arg: " + sum(5));
        System.out.println("Sum when we have many args: " + sum(1, 2, 3, 4));

        System.out.println("\n=== Concatenate ===");
        System.out.println(concatenate("Java", "is", "awesome"));

        try {
            System.out.println("\n=== Find Max ===");
            System.out.println(findMax(3, 7, 2, 9, 1));
            System.out.println(findMax());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\n=== Print All ===");
            printAll("Hello", 42, true, 3.14);
            printAll();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\n=== Mixed Params ===");
            System.out.println(format("Values", 1, 2, 3));
            System.out.println(format("Values"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

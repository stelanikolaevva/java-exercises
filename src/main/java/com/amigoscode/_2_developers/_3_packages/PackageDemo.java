package com.amigoscode._2_developers._3_packages;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static com.amigoscode._2_developers._2_conditionals.IfStatements.evenOrOdd;
import static java.lang.Math.PI;

/**
 * Package and Import Exercises
 *
 * Practice importing classes from java.util and java.time, using fully qualified
 * class names, importing static members, and referencing classes from other packages.
 */
public class PackageDemo {

    /**
     * Creates a List of three fruit names and prints it.
     */
    public static void useListFromUtil() {
        List<String> list = Arrays.asList("apple", "raspberry", "kiwi");
        System.out.println(list);
    }

    /**
     * Prints today's date using LocalDate.now().
     */
    public static void printToday() {
        System.out.println(LocalDate.now());
    }

    /**
     * Uses a fully qualified class name to create a HashMap without importing it.
     * Adds two entries and prints the map.
     */
    public static void useFullyQualifiedName() {
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();
        map.put("Alice", 90);
        map.put("Bob", 85);
        System.out.println(map);
    }

    /**
     * Returns the area of a circle with the given radius.
     * Uses the statically imported PI constant.
     *
     * @param radius the radius of the circle
     * @return the area
     */
    public static double circleArea(double radius) {
        return PI * radius * radius;
    }

    /**
     * Creates an instance of a class from another package in this project
     * and prints it.
     */
    public static void useClassFromAnotherPackage() {
        System.out.println(evenOrOdd(4));
    }

    static void main(String[] args) {
        System.out.println("=== Using java.util.List ===");
        useListFromUtil();

        System.out.println("\n=== Print Today's Date ===");
        printToday();

        System.out.println("\n=== Fully Qualified Class Name ===");
        useFullyQualifiedName();

        System.out.println("\n=== Static Import (PI) ===");
        System.out.println("Area of circle with radius 5: " + circleArea(5));

        System.out.println("\n=== Class From Another Package ===");
        useClassFromAnotherPackage();
    }
}

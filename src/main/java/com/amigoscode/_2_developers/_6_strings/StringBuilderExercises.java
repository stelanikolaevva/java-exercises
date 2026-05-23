package com.amigoscode._2_developers._6_strings;

/**
 * StringBuilder Exercises
 *
 * Practice using StringBuilder for efficient string manipulation.
 * Unlike String, StringBuilder is mutable — you can modify it without
 * creating new objects. This is especially important in loops.
 */
public class StringBuilderExercises {

    /**
     * Builds a greeting message by appending parts.
     *
     * @param name the person's name
     * @param age  the person's age
     * @return "Hello, [name]! You are [age] years old."
     */
    public static String buildGreeting(String name, int age) {
        StringBuilder greeting = new StringBuilder("Hello, ");
        greeting.append(name).append("! Your are ").append(age).append(" years old.");
        return greeting.toString();
    }

    /**
     * Inserts a middle name into a full name at the correct position.
     * Given "John Smith" and middle name "Michael", returns "John Michael Smith".
     *
     * @param fullName   the full name with first and last name
     * @param middleName the middle name to insert
     * @return the full name with the middle name inserted after the first name
     */
    public static String insertMiddleName(String fullName, String middleName) {
        StringBuilder sb = new StringBuilder(fullName);
        int indexOfFirstSpace = sb.indexOf("\\s");
        sb.insert(indexOfFirstSpace + 1, middleName + " ");
        return sb.toString();
    }

    /**
     * Removes all vowels (a, e, i, o, u — both cases) from the text.
     *
     * @param text the original text
     * @return the text with vowels removed
     */
    public static String removeVowels(String text) {
        StringBuilder sb = new StringBuilder(text);
        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if ("aeiouAEIOU".indexOf(ch) >= 0) {
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }

    /**
     * Reverses the given text using StringBuilder's reverse() method.
     *
     * @param text the original text
     * @return the reversed text
     */
    public static String reverseText(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    /**
     * Demonstrates converting between StringBuilder and String.
     * Takes a string, converts to StringBuilder, modifies it, converts back.
     *
     * @param text the original text
     * @return the text converted to uppercase with "!!!" appended
     */
    public static String convertDemo(String text) {
        StringBuilder sb = new StringBuilder(text);
        String textFromSBInUpperCase = sb.toString().toUpperCase();
        return new StringBuilder(textFromSBInUpperCase).append("!!!").toString();
    }

    /**
     * Converts an array of values into a CSV (comma-separated values) line.
     * Example: ["Alice", "30", "London"] -> "Alice,30,London"
     *
     * @param values the array of values
     * @return a CSV line with values separated by commas (no trailing comma)
     */
    public static String buildCsvLine(String[] values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            if (i < values.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    static void main(String[] args) {
        System.out.println("=== Build Greeting ===");
        System.out.println(buildGreeting("Alice", 25));

        System.out.println("\n=== Insert Middle Name ===");
        System.out.println(insertMiddleName("John Smith", "Michael"));

        System.out.println("\n=== Remove Vowels ===");
        System.out.println(removeVowels("Hello World"));

        System.out.println("\n=== Reverse ===");
        System.out.println(reverseText("Java"));

        System.out.println("\n=== Convert Demo ===");
        System.out.println(convertDemo("hello world"));

        System.out.println("\n=== Build CSV ===");
        System.out.println(buildCsvLine(new String[]{"Alice", "30", "London", "Engineer"}));
    }
}

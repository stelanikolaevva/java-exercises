package com.amigoscode._2_developers._12_classes;

/**
 * Enum Exercises
 *
 * Practice creating and using enums in Java. Enums are special classes that
 * represent a fixed set of constants. They can have fields, constructors,
 * and methods just like regular classes.
 */
public class EnumExercises {

    private enum Season {
        SPRING("Flowers bloom"),
        SUMMER("Sun shines"),
        AUTUMN("Leaves fall"),
        WINTER("Smow falls");

        private final String description;

        Season(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public String displayName() {
            String n = name();
            return n.charAt(0) + n.substring(1).toLowerCase();
        }
    }


    private enum Priority {
        LOW(1), MEDIUM(2), HIGH(3);

        private final int level;

        Priority(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }

    static void main(String[] args) {
        System.out.println("=== Season Switch ===");
        switch (Season.SUMMER) {
            case SPRING:
                System.out.println(Season.SPRING.displayName() + ": " + Season.SPRING.getDescription());
                break;
            case SUMMER:
                System.out.println(Season.SUMMER.displayName() + ": " + Season.SUMMER.getDescription());
                break;
            case AUTUMN:
                System.out.println(Season.AUTUMN.displayName() + ": " + Season.AUTUMN.getDescription());
                break;
            case WINTER:
                System.out.println(Season.WINTER.displayName() + ": " + Season.WINTER.getDescription());
                break;
        }


        System.out.println("\n=== Iterate Over Enum Values ===");
        System.out.println("\n== Seasons ==");
        for (Season season : Season.values()) {
            System.out.println(season.ordinal() + ": " + season.name() + " - " + season.getDescription());
        }

        System.out.println("\n== Priorities ==");
        for (Priority priority : Priority.values()) {
            System.out.println(priority.ordinal() + ": " + priority.name() + " - " + priority.getLevel());
        }

    }
}

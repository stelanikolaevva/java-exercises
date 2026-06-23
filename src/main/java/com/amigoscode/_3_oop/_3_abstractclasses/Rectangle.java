package com.amigoscode._3_oop._3_abstractclasses;

/**
 * Exercise: Abstract Classes - Rectangle
 * <p>
 * Implement a concrete Rectangle class that extends the abstract Shape.
 * You must implement all abstract methods declared in Shape.
 * <p>
 * Key concepts:
 * - Extending an abstract class
 * - Implementing abstract methods
 * - Working with multiple fields
 */

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * width * height;
    }

    public static void main(String[] args) {
        // Uncomment and test after completing the TODOs:
        Rectangle rect = new Rectangle(4.0, 6.0);
        System.out.println("Area: " + rect.area());
        System.out.println("Perimeter: " + rect.perimeter());
        rect.describe();   // inherited concrete method from Shape
        System.out.println(rect);
    }
}

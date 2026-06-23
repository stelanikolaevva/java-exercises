package com.amigoscode._3_oop._4_polymorphism;

import com.amigoscode._3_oop._3_abstractclasses.Circle;
import com.amigoscode._3_oop._3_abstractclasses.Rectangle;
import com.amigoscode._3_oop._3_abstractclasses.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Exercise: Polymorphism - Shape Calculator
 * <p>
 * Use polymorphism to write methods that work with any Shape.
 * Because Circle and Rectangle both extend Shape, a single method
 * can handle both — and any future Shape subclass — without modification.
 * <p>
 * Key concepts:
 * - Methods that accept a supertype parameter
 * - Polymorphic collections (List<Shape>)
 * - instanceof with pattern matching (Java 16+)
 * - Open/closed principle in practice
 * <p>
 * Prerequisites: Complete Shape.java, Circle.java, and Rectangle.java first.
 */
public class ShapeCalculator {

    private static void printShapeArea(Shape shape) {
        System.out.println("The " + shape.getClass().getSimpleName() + " has an area of " + String.format("%.2f", shape.area()));
    }

    private static double totalArea(List<Shape> shapes) {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.area();
        }
        return area;
    }


    private static Shape largestShape(List<Shape> shapes) {
        if (shapes.isEmpty()) {
            return null;
        }
        Shape largest = new Rectangle(0, 0);
        for (Shape shape : shapes) {
            if (shape.area() > largest.area()) {
                largest = shape;
            }
        }
        return largest;
    }

    private static String describeShape(Shape shape) {
        if (shape instanceof Circle) {
            return "Circle detected with area: " + shape.area();
        } else if (shape instanceof Rectangle) {
            return "Rectangle detected with area: " + shape.area();
        } else return "Unknown shape with area: " + shape.area();
    }

    private static String formatSummary(List<Shape> shapes) {
        return String.format("Summary: %d shapes, total area: %.2f, largest area: %.2f", shapes.size(), totalArea(shapes), Objects.requireNonNull(largestShape(shapes)).area());
    }

    // TODO: 6 - In main, create a List<Shape> with at least two Circles
    //   and two Rectangles. Call all the methods above and print results.
    //   This demonstrates polymorphism: the same method handles
    //   different shape types seamlessly.

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(12));
        shapes.add(new Circle(22));
        shapes.add(new Rectangle(12, 12));
        shapes.add(new Rectangle(22, 22));

        for (Shape shape : shapes) {
            System.out.println(describeShape(shape));
            printShapeArea(shape);
        }
        totalArea(shapes);
        largestShape(shapes);
        formatSummary(shapes);
    }
}

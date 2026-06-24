package com.amigoscode._5_generics._5_boundedtypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: Multiple Bounds
 *
 * This exercise demonstrates how a type parameter can have multiple bounds.
 * The syntax is: <T extends ClassBound & InterfaceBound1 & InterfaceBound2>
 * If a class is included, it must come first.
 *
 * Complete the TODOs below.
 */
public class MultipleBounds {

    interface Printable<T> {
        void print();
    }

    static <T extends Comparable<T> & Printable<T>> T findMin(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        T min = list.getFirst();
        for (T t : list) {
            if (t.compareTo(min) < 0) {
                min = t;
            }
        }
        return min;
    }


    static class Student implements Comparable<Student>, Printable {
        private String name;
        private double grade;

        public Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public int compareTo(Student other) {
            return Double.compare(this.grade, other.grade);  // ascending by grade
        }

        @Override
        public void print() {
            System.out.println("Student{name='" + name + "', grade=" + grade + "}");
        }


        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", grade=" + grade +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 5.0));
        students.add(new Student("Jane", 6.0));
        students.add(new Student("Jane", 4.0));
        findMin(students).print();



        // Add a comment below explaining:
        //  (a) Why must a class bound come before interface bounds?
        //      e.g., <T extends SomeClass & SomeInterface> is valid
        //      but  <T extends SomeInterface & SomeClass> is NOT valid
        //  (b) Can you have multiple class bounds? Why or why not?
        //  (c) How many interface bounds can you have?

        //a- we can extend 1 class and implement multiple interfaces
        //b - we can extend only 1 class
        //c - as much as we want

    }
}

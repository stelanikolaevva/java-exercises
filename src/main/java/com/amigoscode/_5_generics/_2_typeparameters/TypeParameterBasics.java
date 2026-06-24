package com.amigoscode._5_generics._2_typeparameters;

/**
 * Exercise: Type Parameter Basics
 *
 * This exercise introduces generic type parameters.
 * You will create a simple generic Container class that can hold
 * any type of object while maintaining type safety.
 *
 * Complete the TODOs below to build and test your generic Container.
 */
public class TypeParameterBasics {

    static class Container<T> {
        private T value;

        public Container(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Container{" +
                    "value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {


        Container<String> container = new Container<>("Java Generics");
        Container<Integer> container2 = new Container<>(204);
        System.out.println(container.toString());
        System.out.println(container2.toString());

        // Demonstrate type safety: try to call setValue(123) on the
        //  Container<String> instance. Comment it out and explain why the
        //  compiler rejects it. Then call setValue with a valid String and
        //  print the updated container.

        // Because the Container T is fixed to String so setValue expects a String.
        // Passing an int violates that and compiler rejects it at compile time

        //container.setValue(123);
        container.setValue("New value");
        System.out.println(container.toString());
    }
}

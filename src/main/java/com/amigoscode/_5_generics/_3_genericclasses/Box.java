package com.amigoscode._5_generics._3_genericclasses;

/**
 * Exercise: Generic Box Class
 *
 * This exercise has you build a generic Box<T> class that can store
 * a single item of any type. Think of it as a container that can hold
 * exactly one object.
 *
 * Complete the TODOs below.
 */
public class Box<T> {

    private T content;

    public void put(T item) {
        this.content = item;
    }

    public T get() {
        return this.content;
    }

    public boolean isEmpty() {
        return this.content == null;
    }

    @Override
    public String toString() {
        return "Box{" +
                "content=" + content +
                '}';
    }

    public static void main(String[] args) {

        Box<String> box = new Box<>();
        box.put("Hello Generics");
        System.out.println("Box 1: "+ box.get());
        System.out.println("Is empty: "+ box.isEmpty());

        // TODO: 6 - Create a Box<Double>, put 3.14 in it, retrieve the value
        //  using get(), and print it. Then create another Box<Double> without
        //  putting anything in it and verify isEmpty() returns true.

        Box<Double> anotherBox = new Box<>();
        anotherBox.put(3.14);
        System.out.println("Box 2: "+ anotherBox.get());
        System.out.println("Is empty: "+ anotherBox.isEmpty());

        Box<Double> otherBox = new Box<>();
        System.out.println("Box 3: "+ otherBox.get());
        System.out.println("Is empty: "+ otherBox.isEmpty());

    }
}

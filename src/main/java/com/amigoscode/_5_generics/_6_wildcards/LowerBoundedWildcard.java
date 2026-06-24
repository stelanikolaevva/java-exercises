package com.amigoscode._5_generics._6_wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: Lower Bounded Wildcards (? super T)
 *
 * A lower bounded wildcard <? super Integer> accepts Integer and all its
 * supertypes (Number, Object). This is useful when you want to WRITE to
 * a generic structure.
 *
 * PECS principle: Producer Extends, Consumer Super.
 * When a list CONSUMES values (you write to it), use "super".
 *
 * Complete the TODOs below.
 */
public class LowerBoundedWildcard {

    static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    static <T> void moveElements(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        addNumbers(integers);
        addNumbers(numbers);
        addNumbers(objects);

        System.out.println(integers);
        System.out.println(numbers);
        System.out.println(objects);


        List<? super Integer> ints = new ArrayList<Number>();
        ints.add(1);
        ints.add(12);
        ints.add(112);
        System.out.println(ints);
        // list.add(3.14);  // Why doesn't this compile even though list holds Numbers?

        moveElements(integers, ints);
        System.out.println(ints);

        //We use extends when we read from a collection and super when we write to it.
    }
}

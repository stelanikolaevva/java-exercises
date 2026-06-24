package com.amigoscode._5_generics._4_genericmethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Exercise: Generic Methods
 *
 * This exercise focuses on writing static generic methods.
 * Generic methods declare their own type parameters independently
 * of any generic class. The type parameter appears before the return type.
 *
 * Complete the TODOs below.
 */
public class GenericMethods {

    static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static <T> T getFirst(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    static <T> T getLast(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.getLast();
    }


    static <T> List<T> filterNulls(List<T> list) {
        return list.stream().filter(Objects::nonNull).toList();
    }

    static <T> boolean contains(T[] array, T target) {
        for (T t : array) {
            if (Objects.equals(t, target))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Integer[] intArray = new Integer[]{1, 2, 3};
        String[] stringArray = new String[]{"a", "b", "c"};
        GenericMethods.<Integer>printArray(intArray);
        GenericMethods.<String>printArray(stringArray);

        List<String> names = new ArrayList<>(List.of("Alice", "Bob", "Carol"));
        System.out.println(GenericMethods.<String>getFirst(names));
        System.out.println(GenericMethods.<String>getLast(names));
        names.add(null);
        System.out.println(GenericMethods.<String>filterNulls(names));

        String[] names2 = {"Alice", "Bob", "Carol"};
        System.out.println(GenericMethods.<String>contains(names2, "Alice"));
        System.out.println(GenericMethods.<String>contains(names2, "Amaya"));

        //compiler looks at the types of the arguments you pass and detects T automatically
        printArray(new Integer[]{1, 2, 3});

    }
}

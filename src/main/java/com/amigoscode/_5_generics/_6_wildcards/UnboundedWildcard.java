package com.amigoscode._5_generics._6_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Unbounded Wildcards (?)
 *
 * The unbounded wildcard <?> represents an unknown type.
 * A List<?> can refer to a list of any type, but you cannot add elements
 * to it (except null) because the compiler does not know the actual type.
 *
 * Complete the TODOs below.
 */
public class UnboundedWildcard {

    static void printList(List<?> list) {
        list.forEach(System.out::println);
    }

    static int getSize(List<?> list){
        return list.size();
    }

    public static void main(String[] args) {

        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Double> doubleBox = Arrays.asList(1.1, 2.2, 3.3);

        printList(words);
        printList(integers);
        printList(doubleBox);

        System.out.println(getSize(words));
        System.out.println(getSize(integers));
        System.out.println(getSize(doubleBox));

        // List<?> unknownList = Arrays.asList("a", "b", "c");
        // unknownList.add("d");       // Why does this not compile?
        // unknownList.add(1);         // Why does this not compile either?
        //The compiler cannot perform type check of ? so the adding is prihibited

        List<?> list  = Arrays.asList(1,2,3);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.clear();
        System.out.println(list.remove(0));
    }
}

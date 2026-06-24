package com.amigoscode._5_generics._7_typeerasure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Type Erasure
 *
 * Java generics use "type erasure" -- the compiler enforces type safety at
 * compile time, then removes (erases) all generic type information at runtime.
 * This means List<String> and List<Integer> are both just List at runtime.
 *
 * This exercise explores the consequences and limitations of type erasure.
 *
 * Complete the TODOs below.
 */
public class TypeErasureDemo {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("Hello", "World");
        List<Integer> intList = Arrays.asList(1, 2, 3);
        System.out.println(stringList.getClass() == intList.getClass());
        System.out.println(stringList.getClass());
        //They are an ArrayList in a runtime, type eraser removes the generics. It is only used in compile time for type-checks

        System.out.println(stringList.getClass().getName());
        System.out.println(intList.getClass().getName());


        // TODO: 3 - Show that instanceof works with raw types but NOT with
        //  parameterized types. Uncomment the code below, observe the error,
        //  then comment it back out. Write the correct version using the raw type.
        //
         if (stringList instanceof ArrayList<String>) { }  // Does this compile?
        //It will compile but it won't be true, stringList is just an ArrayList

        //  Write the working version:
          if (stringList instanceof ArrayList) {
              System.out.println("Class: " + stringList.getClass());
          }
        //  Add a comment explaining why you cannot use instanceof with generics.


        // TODO: 4 - Show that you cannot create a generic array.
        //  Uncomment the line below and observe the compile error.
        //  Comment it back out and add an explanation.
        //
        // public static <T> T[] createArray(int size) {
        //     return new T[size];  // Why doesn't this compile?
        // }
        //
        //  Explain: Since T is erased at runtime, the JVM would not know
        //  what type of array to create. What workaround exists?


        // TODO: 5 - Add a comment below summarizing:
        //  (a) What is type erasure?
        //  (b) When does it happen (compile-time or runtime)?
        //  (c) What are the main limitations it causes?
        //      (List at least 3: instanceof, array creation, and one more)
        //  (d) Why did Java choose type erasure? (Hint: backward compatibility)

    }



}

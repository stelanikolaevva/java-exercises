package com.amigoscode._5_generics._4_genericmethods;

import java.util.Arrays;

/**
 * Exercise: Generic Swap and Reverse
 *
 * This exercise practices generic methods by implementing swap and reverse
 * operations that work with arrays of any type.
 *
 * Complete the TODOs below.
 */
public class GenericSwap {

    static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static <T> T[] reverse(T[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            swap(array, i, array.length - i - 1);
        }
        return array;
    }

    public static void main(String[] args) {

        Integer[] intArray = new Integer[]{1, 2, 3, 4, 5};
        swap(intArray, 0, intArray.length - 1);
        System.out.println(Arrays.toString(intArray));

        String[] stringArray = new String[]{"A", "B", "C", "D"};
        swap(stringArray, 1, 2);
        System.out.println(Arrays.toString(stringArray));

        System.out.println(Arrays.toString(reverse(intArray)));
        System.out.println(Arrays.toString(reverse(stringArray)));
    }
}

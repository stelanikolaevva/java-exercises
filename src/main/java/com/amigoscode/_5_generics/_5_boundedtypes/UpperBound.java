package com.amigoscode._5_generics._5_boundedtypes;

import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Upper Bounded Type Parameters
 *
 * This exercise demonstrates bounded type parameters using "extends".
 * When you write <T extends Number>, T can only be Number or its subclasses
 * (Integer, Double, Long, etc.). This lets you call Number methods like
 * doubleValue() on values of type T.
 *
 * Complete the TODOs below.
 */
public class UpperBound {

    static <T extends Number> double sum(List<T> list) {
        double sum = 0.0;
        for (T number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    static <T extends Number> T findMax(List<T> list) {
        if (list.isEmpty())
            return null;
        T max = list.getFirst();
        for (T number : list) {
            if (number.doubleValue() > max.doubleValue())
                max = number;
        }
        return max;
    }

    static class NumberBox<T extends Number> {
        private T number;

        public NumberBox(T number) {
            this.number = number;
        }

        public boolean isPositive() {
            return number.doubleValue() > 0;
        }

        public int toInt() {
            return number.intValue();
        }

        public double toDouble() {
            return number.doubleValue();
        }
    }

    public static void main(String[] args) {

        // TODO: 6 - Test sum() and findMax() with:
        //  (a) A List<Integer> e.g., Arrays.asList(1, 2, 3, 4, 5)
        //  (b) A List<Double> e.g., Arrays.asList(1.5, 2.5, 3.5)
        //  Print the results for each.
        //  Also create a NumberBox<Integer> and NumberBox<Double> and test
        //  isPositive(), toInt(), and toDouble().

        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        System.out.println(sum(ints));
        System.out.println(sum(doubles));
        System.out.println(findMax(ints));
        System.out.println(findMax(doubles));

        NumberBox<Integer> intBox = new NumberBox<>(1);
        System.out.println(intBox.toInt());
        System.out.println(intBox.toDouble());
        System.out.println(intBox.isPositive());

        NumberBox<Double> doubleBox = new NumberBox<>(-1.1);
        System.out.println(doubleBox.toInt());
        System.out.println(doubleBox.toDouble());
        System.out.println(doubleBox.isPositive());

        //  Uncomment the line below and observe the compile error.
        //  Then comment it back out and add a comment explaining why it fails.
        //
         //List<String> strings = Arrays.asList("a", "b");
        // double result = sum(strings);  // Why does this not compile?
        //String is not a subclass of NUMBER
    }
}

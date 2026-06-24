package com.amigoscode._5_generics._3_genericclasses;

import java.util.Objects;

/**
 * Exercise: Generic Pair Class
 *
 * This exercise has you build a generic Pair<K, V> class that holds
 * two related values of potentially different types, like a key-value pair.
 *
 * Complete the TODOs below.
 */
public class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }


    public Pair<V, K> swap() {
        return new Pair<>(this.value, this.key);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    public static void main(String[] args) {

        Pair<String, Integer> person = new Pair<>("Alice", 30);
        System.out.println(person.toString());

        Pair<Integer, String> swappedPerson = person.swap();
        System.out.println(swappedPerson.toString());


        Pair<String, Integer> person2 = new Pair<>("Alice", 30);
        System.out.println(person.equals(person2));
    }
}

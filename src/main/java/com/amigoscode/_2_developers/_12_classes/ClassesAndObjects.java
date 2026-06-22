package com.amigoscode._2_developers._12_classes;

import java.util.Objects;

/**
 * Classes and Objects Exercises
 *
 * Practice creating classes with fields, constructors, and methods.
 * Learn about constructor chaining, toString(), and equals().
 */
public class ClassesAndObjects {

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person() {
            this("Unknown", 0);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Person person)) return false;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }


    static void main(String[] args) {

        Person alice = new Person("Alice", 30);
        Person person = new Person();
        Person alice2 = new Person("Alice", 30);

        System.out.println(alice);
        System.out.println(person);
        System.out.println(alice2);

        System.out.println(alice.equals(alice2));
        System.out.println(alice.equals(person));

        System.out.println("No-args person: " + person);
    }
}

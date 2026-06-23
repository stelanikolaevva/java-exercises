package com.amigoscode._3_oop._2_inheritance;

/**
 * Exercise: Inheritance - Subclass
 *
 * Create a Dog class that extends Animal. Practice using super()
 * to call the parent constructor, overriding methods, and adding
 * behavior specific to the subclass.
 *
 * Key concepts:
 * - Extending a parent class
 * - Calling super() in the constructor
 * - Overriding methods with @Override
 * - Adding subclass-specific fields and methods
 */

public class Dog extends Animal {

    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(this.name + " says: Woof! Woof!");
    }

    // TODO: 5 - Add a fetch(String item) method specific to Dog.
    //   This method should print:
    //   "<name> fetches the <item>!"
    //   This method does not exist in Animal — it is unique to Dog.

    public void fetch(String item) {
        System.out.println(this.name + " fetches the " + item + "!");
    }

    // TODO: 6 - Override toString() to return:
    //   "Dog{name='XXX', age=XXX, breed='XXX'}"


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", breed=" + breed +
                '}';
    }

    public static void main(String[] args) {
        // Uncomment and test after completing the TODOs:
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        System.out.println(dog);
        dog.makeSound();
        dog.eat("kibble");       // inherited from Animal
        dog.fetch("tennis ball"); // specific to Dog

        // Polymorphism: a Dog IS-AN Animal
        Animal animal = new Dog("Rex", 5, "German Shepherd");
        animal.makeSound(); // calls Dog's overridden version
    }
}

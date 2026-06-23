package com.amigoscode._3_oop._6_solid.todo4;

public class HumanWorker implements Sleepable, Workable , Eatable {

    @Override
    public void eat() {
        System.out.println("Human eating");    }

    @Override
    public void sleep() {
        System.out.println("Human sleeping");
    }

    @Override
    public void work() {
        System.out.println("Human working");
    }
}

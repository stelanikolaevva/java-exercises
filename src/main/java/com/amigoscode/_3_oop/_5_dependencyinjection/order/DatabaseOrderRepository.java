package com.amigoscode._3_oop._5_dependencyinjection.order;


public class DatabaseOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        System.out.println("[Database] Order saved: " + order);
    }
}

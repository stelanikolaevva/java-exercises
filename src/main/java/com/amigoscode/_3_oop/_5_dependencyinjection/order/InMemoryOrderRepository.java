package com.amigoscode._3_oop._5_dependencyinjection.order;


public class InMemoryOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        System.out.println("[Repository] Order saved: " + order);
    }
}

package com.amigoscode._3_oop._5_dependencyinjection.order;

public class Order {
    private String id;
    private String item;
    private double amount;

    public Order(String id, String item, double amount) {
        this.id = id;
        this.item = item;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", item='" + item + '\'' +
                ", amount=" + amount +
                '}';
    }
}

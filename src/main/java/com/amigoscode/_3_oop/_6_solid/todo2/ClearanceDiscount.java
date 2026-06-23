package com.amigoscode._3_oop._6_solid.todo2;

public class ClearanceDiscount implements Discount {
    @Override
    public double apply(double price) {
        return price * 0.50;
    }
}

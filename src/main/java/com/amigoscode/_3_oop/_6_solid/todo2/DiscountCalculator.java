package com.amigoscode._3_oop._6_solid.todo2;

public class DiscountCalculator {
    public double calculate(Discount discount, double price) {
        return discount.apply(price);
    }

}

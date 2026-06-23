package com.amigoscode._3_oop._6_solid.todo3;

public class ImmutableSquare implements LspShape {
    private final int side;

    public ImmutableSquare(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return side * side;
    }
}

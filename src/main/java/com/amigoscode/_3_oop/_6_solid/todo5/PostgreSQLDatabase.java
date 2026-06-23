package com.amigoscode._3_oop._6_solid.todo5;

public class PostgreSQLDatabase implements Database {
    @Override
    public String query(String sql) {
        return "PostgreSQL result for: " + sql;
    }
}

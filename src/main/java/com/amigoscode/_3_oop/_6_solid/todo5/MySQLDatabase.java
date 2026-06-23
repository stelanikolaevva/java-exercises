package com.amigoscode._3_oop._6_solid.todo5;

public class MySQLDatabase implements Database {
    @Override
    public String query(String sql) {
        return "MySQL result for: " + sql;
    }
}

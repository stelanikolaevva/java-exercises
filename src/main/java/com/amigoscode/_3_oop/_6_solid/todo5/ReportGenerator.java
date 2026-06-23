package com.amigoscode._3_oop._6_solid.todo5;

public class ReportGenerator {
    private final Database database;

    public ReportGenerator(Database database) {
        this.database = database;
    }

    public void generateReport(String sql) {
        System.out.println(database.query(sql));
    }
}

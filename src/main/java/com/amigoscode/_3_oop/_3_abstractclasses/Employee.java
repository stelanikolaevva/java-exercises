package com.amigoscode._3_oop._3_abstractclasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Exercise: Abstract Classes - Employee Hierarchy
 * <p>
 * Build an employee hierarchy using abstract classes. The abstract Employee
 * defines common behavior, while FullTimeEmployee and ContractEmployee
 * provide different pay calculation strategies.
 * <p>
 * Key concepts:
 * - Abstract class with both abstract and concrete methods
 * - Multiple subclasses with different implementations
 * - Polymorphism with a List of the abstract type
 * - Inner classes (classes defined in the same file)
 */

abstract class Employee {

    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract double calculatePay();

    String getDetails() {
        return String.format("%s - Pay: $%.2f", this.name, calculatePay());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", pay=" + calculatePay() +
                '}';
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double calculatePay() {
        return this.baseSalary;
    }
}

class ContractEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public ContractEmployee(String name, double hourlyRate, int hoursWorked) {
        super(name, 0.0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculatePay() {
        return this.hourlyRate * this.hoursWorked;
    }
}

class EmployeeDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new ContractEmployee("Alise Elvis", 250, 11));
        employees.add(new FullTimeEmployee("Mark Muller", 2500));
        for (Employee employee : employees) {
            System.out.println(employee.getDetails());
        }
        System.out.println(getHighestPaid(employees).toString());

    }

    private static Employee getHighestPaid(List<Employee> employees) {
        return employees.stream().max(Comparator.comparingDouble(Employee::calculatePay)).orElse(null);
    }
}

package com.amigoscode._3_oop._6_solid;

import com.amigoscode._3_oop._6_solid.todo1.UserManager;
import com.amigoscode._3_oop._6_solid.todo1.UserNotifier;
import com.amigoscode._3_oop._6_solid.todo1.UserRepository;
import com.amigoscode._3_oop._6_solid.todo1.UserValidator;
import com.amigoscode._3_oop._6_solid.todo2.ClearanceDiscount;
import com.amigoscode._3_oop._6_solid.todo2.Discount;
import com.amigoscode._3_oop._6_solid.todo2.DiscountCalculator;
import com.amigoscode._3_oop._6_solid.todo2.SeasonalDiscount;
import com.amigoscode._3_oop._6_solid.todo5.MySQLDatabase;
import com.amigoscode._3_oop._6_solid.todo5.PostgreSQLDatabase;
import com.amigoscode._3_oop._6_solid.todo5.ReportGenerator;

/**
 * Exercise: SOLID Principles
 *
 * Practice all five SOLID principles by refactoring problematic code
 * into clean, well-structured designs.
 *
 * S - Single Responsibility Principle (SRP)
 * O - Open/Closed Principle (OCP)
 * L - Liskov Substitution Principle (LSP)
 * I - Interface Segregation Principle (ISP)
 * D - Dependency Inversion Principle (DIP)
 */
public class SolidExercises {

    // =========================================================================
    // SRP - Single Responsibility Principle
    // "A class should have only one reason to change."
    //
    // PROBLEM: UserManager below does THREE things — validation, persistence,
    // and notification. If any one of these changes, the whole class changes.
    // =========================================================================

    // This is the BROKEN version. Do not modify it — write the fix below.
    static class UserManagerBroken {
        void createUser(String name, String email) {
            // Validates
            if (name == null || name.isEmpty()) throw new IllegalArgumentException("Invalid name");
            if (!email.contains("@")) throw new IllegalArgumentException("Invalid email");
            // Saves to database
            System.out.println("Saving user " + name + " to database...");
            // Sends welcome email
            System.out.println("Sending welcome email to " + email + "...");
        }
    }

    // =========================================================================
    // OCP - Open/Closed Principle
    // "Open for extension, closed for modification."
    //
    // PROBLEM: Adding a new discount type requires modifying the existing
    // calculateDiscount method with another if/else branch.
    // =========================================================================

    // This is the BROKEN version. Do not modify it.
    static class DiscountCalculatorBroken {
        double calculateDiscount(String type, double price) {
            if ("SEASONAL".equals(type)) return price * 0.10;
            if ("CLEARANCE".equals(type)) return price * 0.50;
            // To add a new type, you must modify THIS method — violates OCP!
            return 0;
        }
    }


    // =========================================================================
    // LSP - Liskov Substitution Principle
    // "Subtypes must be substitutable for their base types."
    //
    // PROBLEM: MutableSquare extends MutableRectangle but breaks the contract.
    // Setting width on a square also changes height, which surprises code
    // that expects normal rectangle behavior.
    // =========================================================================

    // This is the BROKEN version. Do not modify it.
    static class MutableRectangleBroken {
        protected int width;
        protected int height;
        void setWidth(int w) { this.width = w; }
        void setHeight(int h) { this.height = h; }
        int area() { return width * height; }
    }

    static class MutableSquareBroken extends MutableRectangleBroken {
        @Override void setWidth(int w) { this.width = w; this.height = w; }
        @Override void setHeight(int h) { this.width = h; this.height = h; }
        // BUG: rect.setWidth(5); rect.setHeight(3); rect.area() -> 9, not 15!
    }

    // =========================================================================
    // ISP - Interface Segregation Principle
    // "No client should be forced to depend on methods it does not use."
    //
    // PROBLEM: Robot is forced to implement eat() and sleep() even though
    // robots don't eat or sleep.
    // =========================================================================

    // This is the BROKEN version. Do not modify it.
    interface WorkerBroken {
        void work();
        void eat();
        void sleep();
    }

    static class HumanWorkerBroken implements WorkerBroken {
        public void work()  { System.out.println("Human working"); }
        public void eat()   { System.out.println("Human eating"); }
        public void sleep() { System.out.println("Human sleeping"); }
    }

    static class RobotWorkerBroken implements WorkerBroken {
        public void work()  { System.out.println("Robot working"); }
        public void eat()   { /* Robots don't eat — forced to implement! */ }
        public void sleep() { /* Robots don't sleep — forced to implement! */ }
    }



    // =========================================================================
    // DIP - Dependency Inversion Principle
    // "Depend on abstractions, not on concretions."
    //
    // PROBLEM: ReportGenerator directly creates MySQLDatabase inside itself.
    // It is tightly coupled to MySQL and cannot work with any other database.
    // =========================================================================

    // This is the BROKEN version. Do not modify it.
    static class MySQLDatabaseBroken {
        String query(String sql) {
            return "MySQL result for: " + sql;
        }
    }

    static class ReportGeneratorBroken {
        private MySQLDatabaseBroken database = new MySQLDatabaseBroken(); // tight coupling!
        String generateReport() {
            return database.query("SELECT * FROM reports");
        }
    }

    // =========================================================================
    // Main method to test all exercises
    // =========================================================================
    public static void main(String[] args) {
        System.out.println("=== SOLID Exercises ===\n");

        // Test SRP: Create UserValidator, UserRepository, UserNotifier,
        //   and a refactored UserManager. Call createUser("Alice", "alice@test.com").
        UserValidator userValidator = new UserValidator();
        UserRepository userRepository = new UserRepository();
        UserNotifier userNotifier = new UserNotifier();
        UserManager userManager = new UserManager(userRepository, userNotifier, userValidator);

        userManager.createUser("Alice", "alice@test.com");


        // Test OCP: Create a DiscountCalculator and several Discount
        //   implementations. Calculate discounts for a $100 item and print results.
        DiscountCalculator discountCalculator = new DiscountCalculator();
        System.out.println("Seasonal: "+ discountCalculator.calculate(new SeasonalDiscount(), 100));
        System.out.println("Seasonal: "+ discountCalculator.calculate(new ClearanceDiscount(), 100));


        // TODO: 8 - Test DIP: Create a ReportGenerator with MySQLDatabase,
        //   generate a report. Then create another with PostgreSQLDatabase
        //   and generate a report. Print both results to show the
        //   implementation was swapped without changing ReportGenerator.

        ReportGenerator reportGenerator = new ReportGenerator(new MySQLDatabase());
        reportGenerator.generateReport("SELECT * FROM reports");

        ReportGenerator reportGenerator2 = new ReportGenerator(new PostgreSQLDatabase());
        reportGenerator2.generateReport("SELECT * FROM reports");

    }
}

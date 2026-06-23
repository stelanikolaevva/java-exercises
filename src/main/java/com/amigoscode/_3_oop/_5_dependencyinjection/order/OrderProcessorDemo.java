package com.amigoscode._3_oop._5_dependencyinjection.order;

/**
 * Exercise: Dependency Injection - Order Processing
 * <p>
 * Build an order processing system where OrderProcessor depends on
 * abstractions (interfaces) rather than concrete classes. The payment
 * gateway and order repository are injected through the constructor.
 * <p>
 * Key concepts:
 * - Multiple dependencies injected via constructor
 * - Separating concerns (payment vs persistence)
 * - Easy to swap implementations (e.g., test doubles)
 * - Clean, testable architecture
 */

class OrderProcessorDemo {
    public static void main(String[] args) {
        PaymentGateway paymentGateway = new StripeGateway();
        OrderRepository orderRepository = new InMemoryOrderRepository();

        OrderProcessor orderProcessor = new OrderProcessor(paymentGateway, orderRepository);
        Order order = new Order("ORD-001", "Java Course", 29.99);
        System.out.println("Is completed: " + orderProcessor.processOrder(order));

        paymentGateway = new PayPalGateway();
        orderRepository = new DatabaseOrderRepository();
        orderProcessor = new OrderProcessor(paymentGateway, orderRepository);
        System.out.println("Is completed: " + orderProcessor.processOrder(order));

    }
}

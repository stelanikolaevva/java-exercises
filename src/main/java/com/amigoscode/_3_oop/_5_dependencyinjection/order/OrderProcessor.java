package com.amigoscode._3_oop._5_dependencyinjection.order;

public class OrderProcessor {
    private final PaymentGateway paymentGateway;
    private final OrderRepository orderRepository;

    public OrderProcessor(PaymentGateway paymentGateway, OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.orderRepository = orderRepository;
    }

    public boolean processOrder(Order order) {
        boolean isCharged = paymentGateway.charge(order.getAmount());
        if (isCharged) {
            orderRepository.save(order);
            return true;
        } else {
            System.out.println("Payment failed for order: " + order.getId());
            return false;
        }
    }
}

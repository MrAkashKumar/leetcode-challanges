package com.akash.interviews.designPattern.observer;

public class Runner {

    /*
     * 
     * The Observer Pattern allows one object (the subject) 
     * to notify multiple other objects (the observers) about a change in its state.
     * ---------- OR --------------------------------- 
     * The Observer Pattern is used to notify users about order updates/ about availabilty/ about order tracking.
     */

    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        // Register observers
        orderService.addObserver(new EmailService());
        orderService.addObserver(new InventoryService());
        orderService.addObserver(new LoggingService());

        // Place an order
        Order order = new Order("ORD123", "MacBook", 1);
        orderService.placeOrder(order);
    }
}

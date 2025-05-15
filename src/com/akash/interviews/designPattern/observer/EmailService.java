package com.akash.interviews.designPattern.observer;

public class EmailService implements OrderObserver{

    @Override
    public void update(Order order) {
        // TODO 
       System.out.println("📧 Email sent for order: " + order.getOrderId());
    }
    
}

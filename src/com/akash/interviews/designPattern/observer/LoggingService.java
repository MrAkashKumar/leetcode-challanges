package com.akash.interviews.designPattern.observer;

public class LoggingService implements OrderObserver{

    @Override
    public void update(Order order) {
        // TODO 
        System.out.println("📝 Order logged: " + order.getOrderId());
        
    }
    
}

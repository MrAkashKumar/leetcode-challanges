package com.akash.interviews.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements OrderSubject {

    private final List<OrderObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
        
    }

    @Override
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
        
    }

    @Override
    public void notifyObservers(Order order) {
        for (OrderObserver observer : observers) {
            observer.update(order);
        }
    }

    public void placeOrder(Order order) {
        System.out.println("✅ Order placed: " + order.getOrderId());
        notifyObservers(order);
    }
    
}

package com.akash.interviews.designPattern.observer;
/* Subject Interface */
public interface OrderSubject {

    void addObserver(OrderObserver observer);
    void removeObserver(OrderObserver observer);
    void notifyObservers(Order order);
    
}

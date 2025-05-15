package com.akash.interviews.designPattern.observer;

public class InventoryService implements OrderObserver{

    @Override
    public void update(Order order) {
        // TODO 
        System.out.println("📦 Inventory updated for product: " + order.getProduct());
    }
    
}

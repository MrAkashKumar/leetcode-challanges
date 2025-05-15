package com.akash.interviews.designPattern.observer;

/* Order Class (Data Model) */

public class Order {

    private final String orderId;
    private final String product;
    private final int quantity;

    public Order(String orderId, String product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    public String getOrderId() { return orderId; }

    public String getProduct() { return product; }

    public int getQuantity() { return quantity; }
}

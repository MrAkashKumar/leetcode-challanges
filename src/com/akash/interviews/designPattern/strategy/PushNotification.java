package com.akash.interviews.designPattern.strategy;

public class PushNotification implements NotificationStragtegy{

    @Override
    public void send(String message) {
        System.out.println("Push Sending to "+ message);
    }
    
}

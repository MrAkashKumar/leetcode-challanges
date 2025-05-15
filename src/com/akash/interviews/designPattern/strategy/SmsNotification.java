package com.akash.interviews.designPattern.strategy;

public class SmsNotification implements NotificationStragtegy {

    @Override
    public void send(String message) {
        System.out.println("SMS Sending to "+ message);
    }
    
}

package com.akash.interviews.designPattern.strategy;

public class EmailNotification implements NotificationStragtegy{

    @Override
    public void send(String message) {
        System.out.println("Email Sending to : "+ message);
    }
    


}

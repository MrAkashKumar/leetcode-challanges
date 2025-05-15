package com.akash.interviews.designPattern.strategy;

public class Runner {

    /*
     * The Strategy Pattern defines a family of algorithms, 
     * encapsulates each one, and makes them interchangeable 
     * at runtime without modifying the client code.
     */
    
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();

        //PUSH Notification
        notificationService.setStrategy(new PushNotification());
        notificationService.notifyUser("your order is ready, delivery boy will pick your order");


        // Switch to SMS
        notificationService.setStrategy(new SmsNotification());
        notificationService.notifyUser("Your OTP is 123456");


        // Switch to Email
        notificationService.setStrategy(new EmailNotification());
        notificationService.notifyUser("Welcome Akash !");
    }
}

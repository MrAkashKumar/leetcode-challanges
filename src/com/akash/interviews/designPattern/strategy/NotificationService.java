package com.akash.interviews.designPattern.strategy;

public class NotificationService {
    private NotificationStragtegy notificationStragtegy;

    public void setStrategy(NotificationStragtegy notificationStragtegy){
        this.notificationStragtegy = notificationStragtegy;
    }

    public void notifyUser(String message){
        if(notificationStragtegy == null){
            throw new IllegalStateException("Notifcation can't be empty");
        }
        notificationStragtegy.send(message);

    }
}

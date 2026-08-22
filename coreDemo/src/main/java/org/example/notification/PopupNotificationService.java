package org.example.notification;

public class PopupNotificationService implements NotificationService{

    @Override
    public void sendNotification(){
        System.out.println("Popup notification sent");
    }
}

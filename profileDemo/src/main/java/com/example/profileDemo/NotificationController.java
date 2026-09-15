package com.example.profileDemo;

import org.springframework.http.ResponseEntity;

public class NotificationController {
    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService){
        this.notificationService=notificationService;
    }

    public ResponseEntity<String> sendNotification(){
        String notification=notificationService.send();

        return ResponseEntity.ok(notification);
    }
}

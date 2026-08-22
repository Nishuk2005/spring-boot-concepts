package org.example;

import org.example.notification.EmailService;
import org.example.notification.NotificationService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        NotificationService notification=new EmailService();
        OrderService order=new OrderService(notification);
        order.placeOrder();
    }
}
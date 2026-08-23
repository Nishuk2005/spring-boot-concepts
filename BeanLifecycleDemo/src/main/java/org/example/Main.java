package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order=context.getBean(OrderService.class);
        order.placeOrder();

        UserService userService=context.getBean(UserService.class);
        userService.setBeanName("userBean2");

        CartService cartService=context.getBean(CartService.class);
        System.out.println(cartService.getValue(1));

    }
}
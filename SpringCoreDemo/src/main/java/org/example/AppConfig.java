package org.example;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    @Bean
    public User createUser(){
        return new User("Nishu",23);
    }

    @Bean
    public CartService createCartService(){
        return new CartService();
    }
}

package com.example.transactionDemo2.controller;

import com.example.transactionDemo2.service.OrderService;
import org.springframework.http.ResponseEntity;
import com.example.transactionDemo2.entity.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> placeOrder(
            @RequestBody Order order) {
        orderService.placeOrder(order);
        return ResponseEntity.ok("DONE");
    }
}
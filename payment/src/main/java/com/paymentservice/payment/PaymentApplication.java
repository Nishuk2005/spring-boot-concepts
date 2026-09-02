package com.paymentservice.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);

	}
	//@Autowired                             //Dependency Injection
	private final PaymentService paymentService;

	//Dependency Injection using constructor
	public PaymentApplication(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@Override
	public void run(String... args) throws Exception{
		String payment =paymentService.pay();
		System.out.println("Payment done:"+ payment);
	}

}

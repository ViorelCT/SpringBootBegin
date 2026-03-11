package com.springboot.tutorial;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
        System.out.println("");
        PaymentServiceLog paymentService = new PaymentServiceLog();

        paymentService.processPayment(150);

        paymentService.processPayment(-50);

        paymentService.processPayment(200);


    }
}

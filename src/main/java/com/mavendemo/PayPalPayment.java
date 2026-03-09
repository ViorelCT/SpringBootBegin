package com.mavendemo;

public class PayPalPayment implements PaymentMethod{

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " with PayPal");
    }
}

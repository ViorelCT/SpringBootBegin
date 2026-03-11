package com.springboot.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentServiceLog {

    private static final Logger logger =
            LoggerFactory.getLogger(PaymentServiceLog.class);

    public void processPayment(double amount) {

        logger.info("Processing payment: {}", amount);

        if (amount <= 0) {
            logger.warn("Invalid payment amount: {}", amount);
            return;
        }

        try {

            logger.debug("Payment validation passed for amount {}", amount);

            simulateExternalPaymentSystem();

            logger.info("Payment processed successfully for amount {}", amount);

        } catch (Exception e) {

            logger.error("Payment processing failed for amount {}", amount, e);

        }
    }

    private void simulateExternalPaymentSystem() {

        double random = Math.random();

        if (random < 0.3) {
            throw new RuntimeException("Payment gateway error");
        }
    }
}
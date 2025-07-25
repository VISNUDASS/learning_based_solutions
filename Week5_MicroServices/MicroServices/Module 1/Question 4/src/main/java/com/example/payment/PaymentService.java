package com.example.payment;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackPayment")
    public String makePayment() {
        // Simulate slow third-party API call
        try {
            Thread.sleep(3000); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        throw new RuntimeException("Third-party API is slow or unavailable");
    }

    public String fallbackPayment(Throwable t) {
        logger.warn("Fallback triggered due to: {}", t.getMessage());
        // Monitor fallback event here (e.g., send to monitoring system)
        return "Payment service is currently unavailable. Please try again later.";
    }
}

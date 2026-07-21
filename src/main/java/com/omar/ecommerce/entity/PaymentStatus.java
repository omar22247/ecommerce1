package com.omar.ecommerce.entity;

public enum PaymentStatus {
    PENDING,      // Waiting for gateway response
    SUCCESS,      // Payment completed
    FAILED,       // Payment failed
    REFUNDED      // Money returned
}
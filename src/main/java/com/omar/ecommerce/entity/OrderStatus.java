package com.omar.ecommerce.entity;

public enum OrderStatus {

    PENDING,
    CONFIRMED,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED,
    REFUNDED;

    public boolean canTransitionTo(OrderStatus target) {

        if (target == null) {
            return false;
        }

        return switch (this) {
            case PENDING ->
                    target == CONFIRMED || target == CANCELLED;

            case CONFIRMED ->
                    target == PROCESSING || target == CANCELLED;

            case PROCESSING ->
                    target == SHIPPED || target == CANCELLED;

            case SHIPPED ->
                    target == DELIVERED;

            case DELIVERED ->
                    target == REFUNDED;

            case CANCELLED, REFUNDED ->
                    false;
        };
    }

    public boolean isFinal() {
        return this == CANCELLED
                || this == REFUNDED;
    }
}
package com.omar.ecommerce.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PlaceOrderRequest(
        @NotNull
        UUID addressId
) {}
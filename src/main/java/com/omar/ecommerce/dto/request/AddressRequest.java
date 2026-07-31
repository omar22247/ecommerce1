package com.omar.ecommerce.dto.request;

import jakarta.validation.constraints.NotNull;

public record AddressRequest(
        @NotNull
        String street,
        @NotNull
        String city,
        @NotNull
        String state,
        @NotNull
        String postalCode,
        @NotNull
        String country,
        boolean isDefault
) {
}

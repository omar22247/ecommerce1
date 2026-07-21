package com.omar.ecommerce.dto.response;

public record FieldErrorDetail(
        String field,
        String message
) {}
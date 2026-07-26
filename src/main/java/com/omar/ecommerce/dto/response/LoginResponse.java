package com.omar.ecommerce.dto.response;

public record LoginResponse(
        UserResponseDto user,
        String accessToken,
        String refreshToken,
        String tokenType,
        long expiresIn
) {}
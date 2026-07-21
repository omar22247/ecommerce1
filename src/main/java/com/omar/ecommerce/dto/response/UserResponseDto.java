package com.omar.ecommerce.dto.response;

import com.omar.ecommerce.entity.Role;

import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        Role role,
        boolean enabled
) {}

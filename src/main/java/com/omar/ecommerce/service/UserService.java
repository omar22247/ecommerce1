package com.omar.ecommerce.service;

import com.omar.ecommerce.dto.request.UserRegisterRequest;
import com.omar.ecommerce.dto.response.UserResponseDto;

import java.util.UUID;

public interface UserService {
    UserResponseDto getUserById(UUID id);
    UserResponseDto register(UserRegisterRequest request);
}
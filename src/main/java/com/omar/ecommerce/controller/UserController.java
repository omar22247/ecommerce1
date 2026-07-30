package com.omar.ecommerce.controller;

import com.omar.ecommerce.dto.request.UserRegisterRequest;
import com.omar.ecommerce.dto.response.ApiResponse;
import com.omar.ecommerce.dto.response.UserResponseDto;
import com.omar.ecommerce.security.AuthenticatedUser;
import com.omar.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserById(@AuthenticationPrincipal AuthenticatedUser user) {
        UserResponseDto userDto = userService.getUserById(user.userId());
        return ResponseEntity.ok(ApiResponse.success("User retrieved successfully", userDto));
    }


}
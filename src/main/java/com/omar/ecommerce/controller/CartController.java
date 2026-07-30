package com.omar.ecommerce.controller;

import com.omar.ecommerce.dto.request.AddToCartRequest;
import com.omar.ecommerce.dto.response.ApiResponse;
import com.omar.ecommerce.dto.response.CartResponse;
import com.omar.ecommerce.security.AuthenticatedUser;
import com.omar.ecommerce.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart2")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<CartResponse>> getMyCart(@AuthenticationPrincipal AuthenticatedUser user) {
        CartResponse cart = cartService.getMyCart(user.userId());
        return ResponseEntity.ok(ApiResponse.success("Cart retrieved successfully", cart));
    }

    @PostMapping("/me/items")
    public ResponseEntity<ApiResponse<CartResponse>> addItem(
            @AuthenticationPrincipal AuthenticatedUser user,
            @Valid @RequestBody AddToCartRequest request) {
        CartResponse cart = cartService.addItemToCart(user.userId(), request);
        return ResponseEntity.ok(ApiResponse.success("Item added to cart successfully", cart));
    }
}
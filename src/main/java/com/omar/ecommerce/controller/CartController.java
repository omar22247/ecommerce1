package com.omar.ecommerce.controller;

import com.omar.ecommerce.dto.request.AddToCartRequest;
import com.omar.ecommerce.dto.request.UpdateCartItemRequest;
import com.omar.ecommerce.dto.response.ApiResponse;
import com.omar.ecommerce.dto.response.CartResponse;
import com.omar.ecommerce.security.AuthenticatedUser;
import com.omar.ecommerce.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart")
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
    @DeleteMapping("/me/items/{cartItemId}")
    public ResponseEntity<ApiResponse<CartResponse>> removeItem(
            @AuthenticationPrincipal AuthenticatedUser user,
            @PathVariable Long cartItemId) {
        CartResponse cart = cartService.removeItemFromCart(user.userId(), cartItemId);
        return ResponseEntity.ok(ApiResponse.success("Item removed from cart successfully", cart));
    }
    @PutMapping("/me/items/{cartItemId}")
    public ResponseEntity<ApiResponse<CartResponse>> updateQuantity(
            @AuthenticationPrincipal AuthenticatedUser user,
            @PathVariable Long cartItemId,
            @Valid @RequestBody UpdateCartItemRequest request) {
        CartResponse cart = cartService.updateCartItemQuantity(user.userId(), cartItemId, request);
        return ResponseEntity.ok(ApiResponse.success("Cart item quantity updated successfully", cart));
    }
}
package com.omar.ecommerce.controller;

import com.omar.ecommerce.dto.request.PlaceOrderRequest;
import com.omar.ecommerce.dto.response.ApiResponse;
import com.omar.ecommerce.dto.response.OrderResponse;
import com.omar.ecommerce.security.AuthenticatedUser;
import com.omar.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponse>> placeOrder(
            @AuthenticationPrincipal AuthenticatedUser user,
            @Valid @RequestBody PlaceOrderRequest request) {
        OrderResponse order = orderService.placeOrder(user.userId(), request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Order placed successfully", order));
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<List<OrderResponse>>> listMyOrders(
            @AuthenticationPrincipal AuthenticatedUser user) {
        List<OrderResponse> orders = orderService.listOrders(user.userId());
        return ResponseEntity.ok(ApiResponse.success("Orders retrieved successfully", orders));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<ApiResponse<OrderResponse>> getOrder(
            @AuthenticationPrincipal AuthenticatedUser user,
            @PathVariable UUID orderId) {
        OrderResponse order = orderService.getOrderById(user.userId(), orderId);
        return ResponseEntity.ok(ApiResponse.success("Order retrieved successfully", order));
    }
    @PatchMapping("/{orderId}/cancel")
    public ResponseEntity<ApiResponse<OrderResponse>> cancelOrder(
            @AuthenticationPrincipal AuthenticatedUser user,
            @PathVariable UUID orderId) {
        OrderResponse order = orderService.cancelOrder(user.userId(), orderId);
        return ResponseEntity.ok(ApiResponse.success("Order cancelled successfully", order));
    }
}
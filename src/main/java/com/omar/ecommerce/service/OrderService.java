package com.omar.ecommerce.service;

import com.omar.ecommerce.dto.request.PlaceOrderRequest;
import com.omar.ecommerce.dto.response.OrderResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderResponse placeOrder(UUID userId, PlaceOrderRequest request);
    List<OrderResponse> listOrders(UUID userId);
    OrderResponse getOrderById(UUID userId, UUID orderId);
    OrderResponse cancelOrder(UUID userId, UUID orderId);
}

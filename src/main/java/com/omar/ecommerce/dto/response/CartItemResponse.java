package com.omar.ecommerce.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record CartItemResponse(
        Long id,
        UUID productId,
        String productName,
        BigDecimal unitPrice,
        Integer quantity,
        BigDecimal subtotal
) {}
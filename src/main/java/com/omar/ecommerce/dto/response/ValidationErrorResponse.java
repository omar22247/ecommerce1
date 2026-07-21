package com.omar.ecommerce.dto.response;
import java.time.LocalDateTime;
import java.util.List;

public record ValidationErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        List<FieldErrorDetail> errors,
        String path
) {}
package com.example.identity_service.controller;

import com.example.identity_service.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * ============================================================================
 * Project      : project
 * File         : BaseController.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 1:55 AM
 * Last Updated : 12/1/2025
 * <p>
 * Package      : com.example.identity_service.controller
 * Version      : 1.0
 * <p>
 * Copyright © 12/1/2025. All rights reserved.
 * ============================================================================
 */
public interface BaseController {
    default <T> ResponseEntity<ApiResponse<T>> success() {
        return ResponseEntity.ok(new ApiResponse<>(200, "success", null));
    }

    default <T> ResponseEntity<ApiResponse<T>> success(T data) {
        return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
    }

    default ResponseEntity<ApiResponse<?>> error(int code, String message, HttpStatus status) {
        return ResponseEntity.status(status)
                .body(new ApiResponse<>(code, message, null));
    }
}

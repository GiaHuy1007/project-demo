package com.example.identity_service.exception;

import com.example.identity_service.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

/**
 * ============================================================================
 * Project      : project
 * File         : GlobalExceptionHandler.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 3:07 AM
 * Last Updated : 12/1/2025
 * <p>
 * Package      : com.example.identity_service.exception
 * Version      : 1.0
 * <p>
 * Copyright © 12/1/2025. All rights reserved.
 * ============================================================================
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception exception){
        ErrorCode errorCode = ErrorCode.EXCEPTION;
        return error(errorCode.getCode(), errorCode.getMessage(), errorCode.getStatus());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleException(MethodArgumentNotValidException exception) {
        String enumKey = Objects.requireNonNull(exception.getFieldError()).getDefaultMessage();
        ErrorCode errorCode = ErrorCode.INVALID_KEY;
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        }  catch (IllegalArgumentException e) {
            log.error(e.getMessage());
        }
        return error(errorCode.getCode(), errorCode.getMessage(), errorCode.getStatus());
    }

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiResponse<?>> handleException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        return error(errorCode.getCode(), errorCode.getMessage(), errorCode.getStatus());
    }

    private ResponseEntity<ApiResponse<?>> error(int code, String message, HttpStatus status) {
        return ResponseEntity.status(status)
                .body(new ApiResponse<>(code, message, null));
    }
}

package com.example.identity_service.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

/**
 * ============================================================================
 * Project      : project
 * File         : ErrorCode.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 2:59 AM
 * Last Updated : 12/1/2025
 * <p>
 * Package      : com.example.identity_service.exception
 * Version      : 1.0
 * <p>
 * Copyright © 12/1/2025. All rights reserved.
 * ============================================================================
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    NOT_FOUND(1000, "Not found", HttpStatus.NOT_FOUND),
    INVALID_KEY(1001, "Invalid key", HttpStatus.BAD_REQUEST),
    EXCEPTION(9999, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
    ;
    int code;
    String message;
    HttpStatus status;
}

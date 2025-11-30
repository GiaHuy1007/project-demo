package com.example.identity_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * ============================================================================
 * Project      : project
 * File         : ApiResponse.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 12:31 AM
 * Last Updated : 12/1/2025
 * <p>
 * Package      : com.example.identity_service.dto.response
 * Version      : 1.0
 * <p>
 * Copyright © 12/1/2025. All rights reserved.
 * ============================================================================
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    @Builder.Default
    int code = 200;
    String message;
    T data;
}

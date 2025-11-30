package com.example.identity_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * ============================================================================
 * Project      : project
 * File         : UserUpdateRequest.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 12:00 AM
 * Last Updated : 12/1/2025
 * <p>
 * Package      : com.example.identity_service.dto.request
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
public class UserUpdateRequest {
    String password;
}

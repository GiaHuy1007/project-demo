package com.example.identity_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

/**
 * ============================================================================
 * Project      : project
 * File         : RoleRequest.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 9:47 PM
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
public class RoleRequest {
    String name;
    String description;
    Set<String> permissions;
}

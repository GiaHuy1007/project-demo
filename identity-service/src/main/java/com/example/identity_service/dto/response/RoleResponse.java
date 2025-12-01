package com.example.identity_service.dto.response;

import com.example.identity_service.entity.Permission;

import java.util.Set;

/**
 * ============================================================================
 * Project      : project
 * File         : RoleResponse.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 9:47 PM
 * Last Updated : 12/1/2025
 * <p>
 * Package      : com.example.identity_service.dto.response
 * Version      : 1.0
 * <p>
 * Copyright © 12/1/2025. All rights reserved.
 * ============================================================================
 */
public class RoleResponse {
    String name;
    String description;
    Set<Permission> permissions;
}

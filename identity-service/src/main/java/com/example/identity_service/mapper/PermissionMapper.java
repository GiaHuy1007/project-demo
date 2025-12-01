package com.example.identity_service.mapper;

import com.example.identity_service.dto.request.PermissionRequest;
import com.example.identity_service.dto.response.PermissionResponse;
import com.example.identity_service.entity.Permission;
import org.mapstruct.Mapper;

/**
 * ============================================================================
 * Project      : project
 * File         : PermissionMapper.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 10:15 PM
 * Last Updated : 12/1/2025
 * <p>
 * Package      : com.example.identity_service.mapper
 * Version      : 1.0
 * <p>
 * Copyright © 12/1/2025. All rights reserved.
 * ============================================================================
 */
@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}

package com.example.identity_service.mapper;

import com.example.identity_service.dto.request.RoleRequest;
import com.example.identity_service.dto.response.RoleResponse;
import com.example.identity_service.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * ============================================================================
 * Project      : project
 * File         : RoleMapper.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 9:51 PM
 * Last Updated : 12/1/2025
 * <p>
 * Package      : com.example.identity_service.mapper
 * Version      : 1.0
 * <p>
 * Copyright © 12/1/2025. All rights reserved.
 * ============================================================================
 */
@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest roleRequest);
    RoleResponse toRoleResponse(Role role);
}

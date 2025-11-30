package com.example.identity_service.mapper;

import com.example.identity_service.dto.request.UserCreateRequest;
import com.example.identity_service.dto.response.UserResponse;
import com.example.identity_service.entity.User;
import org.mapstruct.Mapper;

/**
 * ============================================================================
 * Project      : project
 * File         : UserMapper.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 11/30/2025 11:27 PM
 * Last Updated : 11/30/2025
 * <p>
 * Package      : com.example.identity_service.mapper
 * Version      : 1.0
 * <p>
 * Copyright © 11/30/2025. All rights reserved.
 * ============================================================================
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest request);
    UserResponse toUserResponse(User user);
}

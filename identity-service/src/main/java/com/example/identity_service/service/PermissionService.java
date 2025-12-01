package com.example.identity_service.service;

import com.example.identity_service.dto.request.PermissionRequest;
import com.example.identity_service.dto.response.PermissionResponse;
import com.example.identity_service.entity.Permission;
import com.example.identity_service.exception.AppException;
import com.example.identity_service.exception.ErrorCode;
import com.example.identity_service.mapper.PermissionMapper;
import com.example.identity_service.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ============================================================================
 * Project      : project
 * File         : PermissionService.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 10:34 PM
 * Last Updated : 12/1/2025
 * <p>
 * Package      : com.example.identity_service.service
 * Version      : 1.0
 * <p>
 * Copyright © 12/1/2025. All rights reserved.
 * ============================================================================
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> get() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void delete(String name) {
        Permission permission = permissionRepository.findById(name).orElseThrow(()
                -> new AppException(ErrorCode.PERMISSION_NOT_FOUND));
        permissionRepository.deleteById(name);
    }
}

package com.example.identity_service.service;

import com.example.identity_service.dto.request.RoleRequest;
import com.example.identity_service.dto.response.RoleResponse;
import com.example.identity_service.entity.Role;
import com.example.identity_service.exception.AppException;
import com.example.identity_service.exception.ErrorCode;
import com.example.identity_service.mapper.RoleMapper;
import com.example.identity_service.repository.PermissionRepository;
import com.example.identity_service.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * ============================================================================
 * Project      : project
 * File         : RoleService.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 9:46 PM
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
public class RoleService {
    RoleRepository roleRepository;
    RoleMapper roleMapper;
    PermissionRepository permissionRepository;

    public RoleResponse create(RoleRequest request) {
        Role role = roleMapper.toRole(request);
        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));
        roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }
    public List<RoleResponse> get() {
        var roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::toRoleResponse).toList();
    }

    public void delete(String name) {
        Role role = roleRepository.findById(name).orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));
        roleRepository.deleteById(name);
    }
}

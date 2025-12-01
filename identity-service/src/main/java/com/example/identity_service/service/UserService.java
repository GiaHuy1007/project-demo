package com.example.identity_service.service;

import com.example.identity_service.dto.request.UserCreateRequest;
import com.example.identity_service.dto.request.UserUpdateRequest;
import com.example.identity_service.dto.response.UserResponse;
import com.example.identity_service.entity.Role;
import com.example.identity_service.entity.User;
import com.example.identity_service.enums.UserRole;
import com.example.identity_service.exception.AppException;
import com.example.identity_service.exception.ErrorCode;
import com.example.identity_service.mapper.UserMapper;
import com.example.identity_service.repository.RoleRepository;
import com.example.identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ============================================================================
 * Project      : project
 * File         : UserService.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 11/30/2025 11:25 PM
 * Last Updated : 11/30/2025
 * <p>
 * Package      : com.example.identity_service.service
 * Version      : 1.0
 * <p>
 * Copyright © 11/30/2025. All rights reserved.
 * ============================================================================
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    RoleRepository  roleRepository;

    public UserResponse createUser(UserCreateRequest request) {
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roleRepository.findById(UserRole.USER.toString()).ifPresent(roles::add);
        user.setRoles(roles);
        try {
            userRepository.save(user);
        } catch (RuntimeException e) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        return userMapper.toUserResponse(user);
    }

    public UserResponse updateUser(String id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toUserResponse).toList();
    }

    public UserResponse getUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toUserResponse(user);
    }

    public void deleteUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}

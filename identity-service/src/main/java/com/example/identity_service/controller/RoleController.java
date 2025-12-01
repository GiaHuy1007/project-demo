package com.example.identity_service.controller;

import com.example.identity_service.dto.request.RoleRequest;
import com.example.identity_service.dto.response.ApiResponse;
import com.example.identity_service.dto.response.RoleResponse;
import com.example.identity_service.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ============================================================================
 * Project      : project
 * File         : RoleController.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 10:40 PM
 * Last Updated : 12/1/2025
 * <p>
 * Package      : com.example.identity_service.controller
 * Version      : 1.0
 * <p>
 * Copyright © 12/1/2025. All rights reserved.
 * ============================================================================
 */
@RestController
@RequestMapping("roles")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RoleController implements BaseController{
    RoleService roleService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<RoleResponse>>> get() {
        return success(roleService.get());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<RoleResponse>> create(@RequestBody RoleRequest roleRequest) {
        return success(roleService.create(roleRequest));
    }

    @DeleteMapping("/name")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String name) {
        roleService.delete(name);
        return success();
    }
}

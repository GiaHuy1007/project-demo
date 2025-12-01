package com.example.identity_service.controller;

import com.example.identity_service.dto.request.PermissionRequest;
import com.example.identity_service.dto.response.ApiResponse;
import com.example.identity_service.dto.response.PermissionResponse;
import com.example.identity_service.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ============================================================================
 * Project      : project
 * File         : PermissionController.java
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
@RequestMapping("permissions")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PermissionController implements BaseController {
    PermissionService permissionService;

    @PostMapping
    public ResponseEntity<ApiResponse<PermissionResponse>> create(@RequestBody PermissionRequest request) {
        return success(permissionService.create(request));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PermissionResponse>>> get() {
        return success(permissionService.get());
    }

    @DeleteMapping("/name")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String name) {
        permissionService.delete(name);
        return success();
    }
}

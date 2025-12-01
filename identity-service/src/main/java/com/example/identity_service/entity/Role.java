package com.example.identity_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

/**
 * ============================================================================
 * Project      : project
 * File         : Role.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 9:39 PM
 * Last Updated : 12/1/2025
 * <p>
 * Package      : com.example.identity_service.entity
 * Version      : 1.0
 * <p>
 * Copyright © 12/1/2025. All rights reserved.
 * ============================================================================
 */
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    String name;
    String description;
    Set<Permission> permissions;
}

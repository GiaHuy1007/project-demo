package com.example.identity_service.repository;

import com.example.identity_service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ============================================================================
 * Project      : project
 * File         : RoleRepository.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 12/1/2025 9:45 PM
 * Last Updated : 12/1/2025
 * <p>
 * Package      : com.example.identity_service.repository
 * Version      : 1.0
 * <p>
 * Copyright © 12/1/2025. All rights reserved.
 * ============================================================================
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}

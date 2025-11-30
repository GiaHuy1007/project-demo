package com.example.identity_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * ============================================================================
 * Project      : project
 * File         : UserCreateRequest.java
 * Description  : TODO - Mô tả ngắn gọn chức năng của class này.
 * <p>
 * Author       : Gia Huy
 * Created On   : 11/30/2025 11:29 PM
 * Last Updated : 11/30/2025
 * <p>
 * Package      : com.example.identity_service.dto.request
 * Version      : 1.0
 * <p>
 * Copyright © 11/30/2025. All rights reserved.
 * ============================================================================
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {
    String username;
    String password;
    String firstname;
    String lastname;
    LocalDate dob;
    String country;
}

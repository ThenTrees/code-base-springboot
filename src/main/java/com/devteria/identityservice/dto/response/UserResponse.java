/*
 * @ (#) UserResponse.java        1.0 05/05/2024
 *
 * Copyright (c) 2024 student IUH. All rights reserved.
 */

package com.devteria.identityservice.dto.response;

import java.time.LocalDate;
import java.util.Set;

import lombok.*;
import lombok.experimental.FieldDefaults;

/*
 * @description:
 * @author: Tran Le Thien Tri
 * @date: 05/05/2024
 * @version:     1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
    String firstname;
    String lastname;
    LocalDate dob;
    Set<RoleResponse> roles;
}

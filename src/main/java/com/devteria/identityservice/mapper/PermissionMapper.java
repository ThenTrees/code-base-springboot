/*
 * @ (#) UserMapper.java        1.0 05/05/2024
 *
 * Copyright (c) 2024 student IUH. All rights reserved.
 */
package com.devteria.identityservice.mapper;

import org.mapstruct.Mapper;

import com.devteria.identityservice.dto.request.PermissionRequest;
import com.devteria.identityservice.dto.response.PermissionResponse;
import com.devteria.identityservice.entity.Permission;

/*
 * @description:
 * @author: Trần Lê Thiên Trí
 * @date: 05/05/2024
 * @version:     1.0
 */

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);

    //    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}

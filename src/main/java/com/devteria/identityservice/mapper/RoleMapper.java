/*
 * @ (#) UserMapper.java        1.0 05/05/2024
 *
 * Copyright (c) 2024 student IUH. All rights reserved.
 */
package com.devteria.identityservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.devteria.identityservice.dto.request.RoleRequest;
import com.devteria.identityservice.dto.response.RoleResponse;
import com.devteria.identityservice.entity.Role;

/*
 * @description:
 * @author: Trần Lê Thiên Trí
 * @date: 05/05/2024
 * @version:     1.0
 */

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);

    //    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}

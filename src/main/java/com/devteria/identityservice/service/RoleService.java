/*
 * @ (#) RoleService.java        1.0 15/05/2024
 *
 * Copyright (c) 2024 student IUH. All rights reserved.
 */

package com.devteria.identityservice.service;
/*
 * @description:
 * @author: Tran Le Thien Tri
 * @date: 15/05/2024
 * @version:     1.0
 */

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devteria.identityservice.dto.request.RoleRequest;
import com.devteria.identityservice.dto.response.RoleResponse;
import com.devteria.identityservice.entity.Role;
import com.devteria.identityservice.mapper.RoleMapper;
import com.devteria.identityservice.repository.PermissionRepository;
import com.devteria.identityservice.repository.RoleRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RoleService {

    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleResponse createRole(RoleRequest request) {
        Role role = roleMapper.toRole(request);
        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));
        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAllRoles() {
        var roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::toRoleResponse).toList();
    }

    public void deleteRole(String id) {
        roleRepository.deleteById(id);
    }
}

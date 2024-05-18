/*
 * @ (#) UserServiceTest.java        1.0 17/05/2024
 *
 * Copyright (c) 2024 student IUH. All rights reserved.
 */

package com.devteria.identityservice.service;
/*
 * @description:
 * @author: Tran Le Thien Tri
 * @date: 17/05/2024
 * @version:     1.0
 */

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.devteria.identityservice.dto.request.UserCreationRequest;
import com.devteria.identityservice.dto.response.UserResponse;
import com.devteria.identityservice.entity.User;
import com.devteria.identityservice.exception.AppException;
import com.devteria.identityservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private User user;
    private UserCreationRequest request;
    private UserResponse response;
    private LocalDate dob;

    @BeforeEach
    void initData() {
        request = UserCreationRequest.builder()
                .username("tri")
                .password("12345678")
                .firstname("Jonh")
                .lastname("David")
                .dob(dob)
                .build();

        response = UserResponse.builder()
                .id("1")
                .username("tri")
                .firstname("Jonh")
                .lastname("David")
                .dob(dob)
                .build();

        user = User.builder()
                .id("1")
                .username("tri")
                .firstname("Jonh")
                .lastname("David")
                .dob(dob)
                .build();
    }

    @Test
    void createUser_Valid_success() {
        // GIVEN
        Mockito.when(userRepository.existsByUsername(ArgumentMatchers.anyString()))
                .thenReturn(false);
        Mockito.when(userRepository.save(ArgumentMatchers.any())).thenReturn(user);

        // WHEN
        var response = userService.createUser(request);

        // THEN
        Assertions.assertThat(response.getId()).isEqualTo("1");
        Assertions.assertThat(response.getUsername()).isEqualTo("tri");
    }

    @Test
    void createUser_Invalid_UserExist_Fail() {
        // GIVEN
        Mockito.when(userRepository.existsByUsername(ArgumentMatchers.anyString()))
                .thenReturn(true);

        // WHEN
        //        var response = userService.createUser(request);
        var exception = org.junit.jupiter.api.Assertions.assertThrows(
                AppException.class, () -> userService.createUser(request));

        // THEN
        Assertions.assertThat(exception.getErrorCode().getCode()).isEqualTo(1002);
        Assertions.assertThat(exception.getErrorCode().getMessage()).isEqualTo("User existed");
    }
}

/*
 * @ (#) InvalidatedTokenRepository.java        1.0 15/05/2024
 *
 * Copyright (c) 2024 student IUH. All rights reserved.
 */

package com.devteria.identityservice.repository;
/*
 * @description:
 * @author: Tran Le Thien Tri
 * @date: 15/05/2024
 * @version:     1.0
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devteria.identityservice.entity.InvalidatedToken;

@Repository
public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {}

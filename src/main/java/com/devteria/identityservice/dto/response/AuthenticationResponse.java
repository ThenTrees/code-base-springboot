/*
 * @ (#) AuthenticationResponse.java        1.0 06/05/2024
 *
 * Copyright (c) 2024 student IUH. All rights reserved.
 */

package com.devteria.identityservice.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

/*
 * @description:
 * @author: Tran Le Thien Tri
 * @date: 06/05/2024
 * @version:     1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {
    boolean authenticated;
    String token;
}

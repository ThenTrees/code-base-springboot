package com.devteria.identityservice.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

import com.devteria.identityservice.validator.DOBConstraint;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
    String username;

    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;

    String firstname;
    String lastname;

    @DOBConstraint(min = 18)
    LocalDate dob;
}

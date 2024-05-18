/*
 * @ (#) DOBValidator.java        1.0 15/05/2024
 *
 * Copyright (c) 2024 student IUH. All rights reserved.
 */

package com.devteria.identityservice.validator;
/*
 * @description:
 * @author: Tran Le Thien Tri
 * @date: 15/05/2024
 * @version:     1.0
 */

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DOBValidator implements ConstraintValidator<DOBConstraint, LocalDate> {

    private int min;

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (Objects.isNull(value)) {
            return true;
        }

        long year = ChronoUnit.YEARS.between(value, LocalDate.now());

        return year >= min;
    }

    @Override
    public void initialize(DOBConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
    }
}

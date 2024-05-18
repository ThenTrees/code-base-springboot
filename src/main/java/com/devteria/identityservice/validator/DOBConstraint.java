/*
 * @ (#) DOBConstrain.java        1.0 15/05/2024
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

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {DOBValidator.class})
public @interface DOBConstraint {

    /**
     * 3 thuoojc tisnh co ban
     * @return
     */
    String message() default "Invalid date of birth";

    int min();

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}

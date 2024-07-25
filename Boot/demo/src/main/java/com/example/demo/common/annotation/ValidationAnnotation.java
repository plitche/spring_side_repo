package com.example.demo.common.annotation;

import com.example.demo.common.valid.ParameterValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ParameterValidator.class)
public @interface ValidationAnnotation {

    String message() default "Invalid Value. It should be 'hello'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

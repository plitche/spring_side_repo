package com.example.demo.common.annotation;

import com.example.demo.common.valid.ParameterValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ParameterValidator.class)
public @interface ValidationAnnotation {

    String message() default "Invalid Value. It should be 'hello'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

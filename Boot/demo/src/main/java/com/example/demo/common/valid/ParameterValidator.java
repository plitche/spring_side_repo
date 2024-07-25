package com.example.demo.common.valid;

import com.example.demo.common.annotation.ValidationAnnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ParameterValidator implements ConstraintValidator<ValidationAnnotation, String> {

    @Override
    public void initialize(ValidationAnnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.equals("hello");
    }
}

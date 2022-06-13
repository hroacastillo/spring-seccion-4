package com.hroac.springbootform.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequeridoValidation implements ConstraintValidator<Requerido, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

//NOSONAR        return !(value == null || value.isEmpty() || value.isBlank());
        return  !(value == null || !StringUtils.hasText(value));
    }
}

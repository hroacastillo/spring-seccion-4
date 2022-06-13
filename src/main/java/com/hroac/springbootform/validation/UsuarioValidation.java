package com.hroac.springbootform.validation;

import com.hroac.springbootform.model.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
//NOSONAR        Usuario usuario = (Usuario) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","NotEmpty.usuario.nombre");

//NOSONAR        if (!usuario.getIdentificador().matches("[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
//NOSONAR            errors.rejectValue("identificador", "Pattern.usuario.identificador");
//NOSONAR        }
    }
}

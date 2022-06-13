package com.hroac.springbootform.controller;

import com.hroac.springbootform.editors.NombreMayusculaEditor;
import com.hroac.springbootform.model.Usuario;
import com.hroac.springbootform.validation.UsuarioValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidation validator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(String.class, new NombreMayusculaEditor());
    }

    @GetMapping("/form")
    public String form (Model model) {

        Usuario usuario = new Usuario();
        usuario.setNombre("Hector");
        usuario.setApellido("Roa");
        usuario.setIdentificador("123456.789-K");

        model.addAttribute("titulo", "Formulario Usuarios");
        model.addAttribute("usuario", usuario);

        return "form";
    }

    @PostMapping("/form")
    public String procesar (@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {

        validator.validate(usuario,result);

        model.addAttribute("titulo", "Resultado del formulario");

        if (result.hasErrors()) {

            return "form";
        }

        model.addAttribute("usuario", usuario);

        status.setComplete();

        return "resultado";
    }
}

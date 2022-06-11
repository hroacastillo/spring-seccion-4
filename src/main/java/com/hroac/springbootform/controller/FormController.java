package com.hroac.springbootform.controller;

import com.hroac.springbootform.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form (Model model) {

        Usuario usuario = new Usuario();
        usuario.setNombre("Hector");
        usuario.setApellido("Roa");

        model.addAttribute("titulo", "Formulario Usuarios");
        model.addAttribute("usuario", usuario);

        return "form";
    }

    @PostMapping("/form")
    public String procesar (@Valid Usuario usuario, BindingResult result, Model model) {

        model.addAttribute("titulo", "Resultado del formulario");

        if (result.hasErrors()) {

            return "form";
        }

        model.addAttribute("usuario", usuario);

        return "resultado";
    }
}

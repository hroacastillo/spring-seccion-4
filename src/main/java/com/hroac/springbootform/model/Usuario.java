package com.hroac.springbootform.model;

import com.hroac.springbootform.validation.IdentificadorRegex;
import com.hroac.springbootform.validation.Requerido;

import javax.validation.constraints.*;
import java.util.Date;

public class Usuario {
    //@Pattern(regexp = "[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
    @IdentificadorRegex
    private String identificador;
    //@NotEmpty(message = "El nombre de usuario no puede ser vacío")
    private String nombre;
    @Requerido
    private String apellido;
    @NotBlank
    @Size(min = 3, max = 8)
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    @Email(message = "El formato de correo es incorrecto")
    private String email;
    @NotNull
    @Min(5)
    @Max(5000)
    private Integer cuenta;

    @NotNull
    @FutureOrPresent
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    public Usuario() {
    }

    public Usuario(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Usuario(String nombre, String apellido, String username, String password, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

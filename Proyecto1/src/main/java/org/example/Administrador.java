package org.example;

public class Administrador extends Usuario {
    private String nombre;

    public Administrador(String codigo, String contrasena, String nombre) {
        super(codigo, contrasena);
        this.nombre = nombre;
    }
}

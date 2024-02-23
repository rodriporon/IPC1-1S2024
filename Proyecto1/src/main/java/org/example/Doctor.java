package org.example;

public class Doctor extends Usuario {
    private String nombres;
    private String apellidos;
    private String especialidad;

    public Doctor(String codigo, String contrasena, String nombres, String apellidos, String especialidad) {
        super(codigo, contrasena);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}

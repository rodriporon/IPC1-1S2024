package org.example;

public class Usuario {
    protected String codigo;
    protected String contrasena;

    public Usuario(String codigo, String contrasena) {
        this.codigo = codigo;
        this.contrasena = contrasena;
    }

    public boolean autenticar(String codigo, String contrasena) {
        return this.codigo.equals(codigo) && this.contrasena.equals(contrasena);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

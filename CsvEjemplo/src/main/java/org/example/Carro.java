package org.example;

public class Carro {
    private String nombre;
    private int velodidad;
    private int galonesDisponibles;

    public Carro(String nombre, int velodidad, int galonesDisponibles) {
        this.nombre = nombre;
        this.velodidad = velodidad;
        this.galonesDisponibles = galonesDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVelodidad() {
        return velodidad;
    }

    public void setVelodidad(int velodidad) {
        this.velodidad = velodidad;
    }

    public int getGalonesDisponibles() {
        return galonesDisponibles;
    }

    public void setGalonesDisponibles(int galonesDisponibles) {
        this.galonesDisponibles = galonesDisponibles;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "nombre='" + nombre + '\'' +
                ", galonesDisponibles=" + galonesDisponibles +
                '}';
    }
}

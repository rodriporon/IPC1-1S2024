package org.example;

import Interfaz.InterfazInicioSesion;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Administrador administrador = new Administrador("201902781", "password123", "Rodrigo");
    public static List<Doctor> doctores = new ArrayList<>();

    public static void main(String[] args) {

        doctores.add(new Doctor(
                "00001", "passwordDoctor", "Rodrigo Antonio", "Poron", "Cardiologo"
        ));

        doctores.add(new Doctor(
                "00002", "passwordFatima", "Fatima Florisel", "Cerezo", "Pediatra"
        ));

        SwingUtilities.invokeLater(() -> {
            InterfazInicioSesion interfazInicioSesion = new InterfazInicioSesion();
            interfazInicioSesion.setVisible(true);
        });

    }
}
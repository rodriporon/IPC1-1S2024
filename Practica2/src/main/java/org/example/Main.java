package org.example;

import org.example.Interfaz.CarreraInterfaz;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CarreraInterfaz::new);
    }
}
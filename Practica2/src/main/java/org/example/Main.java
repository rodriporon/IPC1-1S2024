package org.example;

import org.example.Interfaz.CarreraInterfaz;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarreraInterfaz carreraInterfaz = new CarreraInterfaz();
            carreraInterfaz.setVisible(true);

            carreraInterfaz.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    carreraInterfaz.guardarEstado();
                    System.exit(0);
                }
            });
        });
    }
}
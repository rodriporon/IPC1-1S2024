package org.example;

import org.example.Interfaz.CarreraInterfaz;
import org.example.Interfaz.VehiculoInterfaz;

import javax.swing.*;
import java.io.Serializable;

public class Carrera implements Runnable, Serializable {
    VehiculoInterfaz vehiculoInterfaz;
    private static final Object lock = new Object();

    public Carrera(VehiculoInterfaz vehiculoInterfaz) {
        this.vehiculoInterfaz = vehiculoInterfaz;
    }

    @Override
    public void run() {
        while (vehiculoInterfaz.getX() < CarreraInterfaz.META_X) {
            vehiculoInterfaz.avanzar();

            if (vehiculoInterfaz.getX() >= CarreraInterfaz.META_X) {
                synchronized (lock) {
                    if (CarreraInterfaz.lblGanador.getText().isEmpty()) {
                        SwingUtilities.invokeLater(() -> CarreraInterfaz.lblGanador.setText(vehiculoInterfaz.getNombre() + " ha ganado!"));
                    }
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

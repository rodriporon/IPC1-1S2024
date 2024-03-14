package org.example.Interfaz;

import org.example.Carrera;

import javax.swing.*;
import java.awt.*;

public class CarreraInterfaz extends JFrame {
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 400;
    private final int VEHICLE_WIDTH = 50;
    private final int VEHICLE_HEIGHT = 50;
    public static final int META_X = 700;

    public static JLabel lblGanador;

    public CarreraInterfaz() {
        initComponents();
    }

    public void initComponents() {
        setTitle("Carrera del Rayo McQueen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(null);

        lblGanador = new JLabel();
        lblGanador.setBounds(WINDOW_WIDTH / 2, 50, 200, 30);
        add(lblGanador);

        VehiculoInterfaz vehiculo1 = new VehiculoInterfaz("Rayo McQueen", Color.RED, VEHICLE_WIDTH, VEHICLE_HEIGHT, 0, 50);
        VehiculoInterfaz vehiculo2 = new VehiculoInterfaz("Mate", Color.YELLOW, VEHICLE_WIDTH, VEHICLE_HEIGHT, 0, 150);

        add(vehiculo1);
        add(vehiculo2);

        Thread hiloCarro1 = new Thread(new Carrera(vehiculo1));
        Thread hiloCarro2 = new Thread(new Carrera(vehiculo2));

        hiloCarro1.start();
        hiloCarro2.start();

        setVisible(true);
    }
}

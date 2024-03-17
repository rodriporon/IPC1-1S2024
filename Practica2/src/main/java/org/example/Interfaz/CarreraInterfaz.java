package org.example.Interfaz;

import org.example.Carrera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CarreraInterfaz extends JFrame {
    private Map<String, VehiculoInterfaz> vehiculos;
    private Map<String, Point> posicionesGuardadas;
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 400;
    private final int VEHICLE_WIDTH = 50;
    private final int VEHICLE_HEIGHT = 50;
    public static final int META_X = 700;

    public static JLabel lblGanador;
    private JButton btnIniciarCarrera;

    public CarreraInterfaz() {
        vehiculos = new HashMap<>();
        posicionesGuardadas = new HashMap<>();

        Map<String, VehiculoInterfaz> estadoInicial = cargarEstado();
        System.out.println("Estado inicial: " + estadoInicial);

        initComponents(estadoInicial);
    }

    public void initComponents(Map<String, VehiculoInterfaz> estadoInicial) {
        setTitle("Carrera del Rayo McQueen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(null);

        lblGanador = new JLabel();
        lblGanador.setBounds(WINDOW_WIDTH / 2, 50, 200, 30);
        add(lblGanador);

        btnIniciarCarrera = new JButton("Iniciar carrera");
        btnIniciarCarrera.setBounds(WINDOW_WIDTH / 2 - 75, WINDOW_HEIGHT - 100, 150, 30);
        btnIniciarCarrera.setEnabled(true);
        btnIniciarCarrera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarCarrera();
            }
        });
        add(btnIniciarCarrera);

        VehiculoInterfaz vehiculo1 = new VehiculoInterfaz("Rayo McQueen", Color.RED, VEHICLE_WIDTH, VEHICLE_HEIGHT, 0, 50);
        VehiculoInterfaz vehiculo2 = new VehiculoInterfaz("Mate", Color.YELLOW, VEHICLE_WIDTH, VEHICLE_HEIGHT, 0, 150);

        if (estadoInicial.isEmpty()) {
            vehiculos.put(vehiculo1.getNombre(), vehiculo1);
            vehiculos.put(vehiculo2.getNombre(), vehiculo2);
        } else {
            for (Map.Entry<String, VehiculoInterfaz> entry : estadoInicial.entrySet()) {
                String nombreVehiculo = entry.getKey();
                VehiculoInterfaz vehiculoDeserializado = estadoInicial.get(nombreVehiculo);
                VehiculoInterfaz vehiculo = new VehiculoInterfaz(
                        nombreVehiculo, vehiculoDeserializado.getColor(), VEHICLE_WIDTH, VEHICLE_HEIGHT, vehiculoDeserializado.getPositionX(), vehiculoDeserializado.getPositionY()
                );
                vehiculos.put(nombreVehiculo, vehiculo);
            }
            btnIniciarCarrera.setEnabled(true);
        }

        for (VehiculoInterfaz vehiculo : vehiculos.values()) {
            add(vehiculo);
        }

        setVisible(true);
    }

    private Map<String, VehiculoInterfaz> cargarEstado() {
        Map<String, VehiculoInterfaz> estado = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("estado.dat"))) {
            System.out.println("Estado de los vehiculos");
            Map<String, VehiculoInterfaz> estadoMap = (Map<String, VehiculoInterfaz>) ois.readObject();
            System.out.println("El estado map es: " + estadoMap);
            estado = estadoMap;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return estado;
    }

    public void guardarEstado() {
        // Guardar las posiciones actuales de los vehiculos

        for (Map.Entry<String, VehiculoInterfaz> entry : vehiculos.entrySet()) {
            String nombreVehiculo = entry.getKey();
            VehiculoInterfaz vehiculo = entry.getValue();
            Point posicion = new Point(vehiculo.getX(), vehiculo.getY());
            posicionesGuardadas.put(nombreVehiculo, posicion);
            System.out.println("Se esta guardando esta posicion: " + posicion);
        }


        // Guardar el estado de los vehiculos

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("estado.dat"))) {
            oos.writeObject(vehiculos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void iniciarCarrera() {
        for (VehiculoInterfaz vehiculo : vehiculos.values()) {
            new Thread(new Carrera(vehiculo)).start();
        }
        btnIniciarCarrera.setEnabled(false);
    }
}

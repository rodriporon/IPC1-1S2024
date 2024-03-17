package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ventana extends JFrame {
    private JButton botonAbrir;
    private JTextArea textArea;

    public Ventana() {
        setTitle("Leer archivo CSV");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        botonAbrir = new JButton("Abrir archivo");
        textArea = new JTextArea();

        botonAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirArchivoCSV();
            }
        });

        setLayout(new BorderLayout());
        add(botonAbrir, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    private void abrirArchivoCSV() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            List<Carro> carros = leerCarrosDesdeCSV(filePath);
            mostrarCarrosEnTextArea(carros);
        }
    }

    private List<Carro> leerCarrosDesdeCSV(String filePath) {
        List<Carro> carros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            br.readLine(); // saltamos la priemera linea porque es el encabezado.
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombreCarro = partes[0].trim();
                int velocidad = Integer.parseInt(partes[1].trim());
                int galonesDisponibles = Integer.parseInt(partes[2].trim());
                carros.add(new Carro(nombreCarro, velocidad, galonesDisponibles));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return carros;
    }

    private void mostrarCarrosEnTextArea(List<Carro> carros) {
        textArea.setText("");
        for (Carro carro : carros) {
            textArea.append(carro.toString());
        }
    }
}

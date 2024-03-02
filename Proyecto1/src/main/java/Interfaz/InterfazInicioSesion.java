package Interfaz;

import org.example.Administrador;
import org.example.Doctor;
import org.example.Main;

import javax.swing.*;
import java.awt.*;

public class InterfazInicioSesion extends JFrame {

    Administrador administrador = Main.administrador;

    public InterfazInicioSesion() {
        initComponents();
    }

    public void initComponents() {
        setTitle("Inicio de Sesion");
        setSize(600, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        JLabel usuarioLabel = new JLabel("Nombre de usuario");
        usuarioLabel.setBounds(10, 10, 150, 30);
        add(usuarioLabel);

        JTextField usuarioField = new JTextField();
        usuarioField.setBounds(160, 10, 150, 30);
        add(usuarioField);

        JLabel contrasenaLabel = new JLabel("Contrasena");
        contrasenaLabel.setBounds(10, 50, 150, 30);
        add(contrasenaLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(160, 50, 150, 30);
        add(passwordField);

        JButton iniciarSesionButton = new JButton("Iniciar Sesion");
        iniciarSesionButton.setBounds(320, 25, 150, 30);
        add(iniciarSesionButton);

        iniciarSesionButton.addActionListener(e -> {
            String codigo = usuarioField.getText();
            String contrasena = new String(passwordField.getPassword());

            if (administrador.autenticar(codigo, contrasena)) {
                JOptionPane.showMessageDialog(this, "Inicio de Sesion correcto");
                SwingUtilities.invokeLater(() -> {
                    InterfazAdministrador interfazAdministrador = new InterfazAdministrador(Main.doctores);
                    interfazAdministrador.setVisible(true);
                });
            } else {
                for (Doctor doctor : Main.doctores) {
                    if (doctor.autenticar(codigo, contrasena)) {
                        JOptionPane.showMessageDialog(this, "Inicio de Sesion de Doctor correcto");
                    }
                }
                JOptionPane.showMessageDialog(this, "Codigo o contrasena incorrectos");
            }


        });


    }
}

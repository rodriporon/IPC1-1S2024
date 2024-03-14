package org.example.Interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class VehiculoInterfaz extends JPanel {
    private String nombre;
    private Color color;
    private int carWidth, carHeight;
    private int positionX, positionY;

    public VehiculoInterfaz(String nombre, Color color, int carWidth, int carHeight, int positionX, int positionY) {
        this.nombre = nombre;
        this.color = color;
        this.carWidth = carWidth;
        this.carHeight = carHeight;
        this.positionX = positionX;
        this.positionY = positionY;

        initComponents();
    }

    public void initComponents() {
        setPreferredSize(new Dimension(this.carWidth, this.carHeight));
        setBounds(this.positionX, this.positionY, this.carWidth, this.carHeight);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawString(this.nombre, 5, getHeight() / 2);
    }

    public void avanzar() {
        Random random = new Random();
        this.positionX += random.nextInt(10) + 1;

        /*
        Esto no deberia ser asi, porque los dos objetos (Rayo McQueen y Mate) tienen uso de este metodo\
        if (this.positionX >= CarreraInterfaz.META_X) {
            CarreraInterfaz.lblGanador.setText(this.nombre + " ha ganado!");
        }
         */
        setLocation(this.positionX, this.positionY);
    }

    public String getNombre() {
        return nombre;
    }
}

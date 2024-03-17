package org.example.Interfaz;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Random;

public class VehiculoInterfaz extends JPanel implements Serializable {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCarWidth() {
        return carWidth;
    }

    public void setCarWidth(int carWidth) {
        this.carWidth = carWidth;
    }

    public int getCarHeight() {
        return carHeight;
    }

    public void setCarHeight(int carHeight) {
        this.carHeight = carHeight;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}

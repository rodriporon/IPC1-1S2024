/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Random;

/**
 *
 * @author rodri
 */
public class Utils {
    
    /*
    public static int obtenerNumeroRandomPenalizacion() {
        Random random = new Random();
        return random.nextInt(2) + 4;
    }
    */
    
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holamundo;

import java.util.Scanner;

/**
 *
 * @author rodri
 */
public class HolaMundo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        
        int opcion;
        
        do {
            System.out.println("***MENU***"); 
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Retomar Juego");
            System.out.println("3. Mostrar informacion del estudiante");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            
            if (opcion == 1) {
               dibujarTablero(); 
            }
            
        } while (opcion != 4);
    }
    
    public static void dibujarTablero() {
        
        int correlativo = 1;
        int filas = 4;
        int columnas = 4;
        String[][] tablero = new String[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // boolean tienePenalizacion = devolverPenalizacionRandom(i,j);\
                if (j == 2) {
                  tablero[i][j] = obtenerCasilla(correlativo, true, true);  
                } else {
                   tablero[i][j] = obtenerCasilla(correlativo, false, true); 
                }
                
                correlativo++;
            }
        }
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public static String obtenerCasilla(int correlativo, boolean tienePenalizacion, boolean jugadorEstaEnLaCasilla) {
        
        String casilla = "";
        
        if (tienePenalizacion && jugadorEstaEnLaCasilla) {
            casilla += "# " + Integer.toString(correlativo) + " @";
        } else if (tienePenalizacion && !jugadorEstaEnLaCasilla) {
            casilla += "# " + Integer.toString(correlativo) + "  ";
        } else if (!tienePenalizacion && jugadorEstaEnLaCasilla) {
            casilla += "  " + Integer.toString(correlativo) + " @";
        } else {
            casilla += "  " + Integer.toString(correlativo) + "  ";
        }
        
        return casilla;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holamundo;

import java.util.Random;
import java.util.Scanner;
import utils.Utils;

/**
 *
 * @author rodri
 */
public class HolaMundo {
    public static int correlativo = 1;
    public static int filas = 4;
    public static int columnas = 4;
    public static String[][] tablero = new String[filas][columnas];

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
        Random random = new Random();
        
        
        
        for (int i = filas - 1; i >= 0; i--) {
            
            // Generar un numero aleatorio entre 2 y 4 para determinar la cantidad de penalizaciones en esta fila.
            
            int numPenalizaciones = Utils.getRandomNumber(2, 4);
            
            /*
            Crear un array para almacenar las columnas en las que se colocaran las penalizaciones
            */
            
            boolean[] columnasConPenalizacion = new boolean[columnas];
            
            for (int k = 0; k < numPenalizaciones; k++) {
              int columna;
              
                do {
                    columna = random.nextInt(columnas);
                } while (columnasConPenalizacion[columna]);
                
                /*
                Marcar la columna actual como que tiene una penalizacion
                
                */
                
                columnasConPenalizacion[columna] = true;
                
                /*
                
                Colocar la penalizacion en la posicion actual
                */
                
                tablero[i][columna] = obtenerCasilla(correlativo, true, false);
            }
            
            
            for (int j = 0; j < columnas; j++) {
                // boolean tienePenalizacion = devolverPenalizacionRandom(i,j);\
                if (i % 2 == 0) {
                    if (tablero[i][j] == null) {
                        tablero[i][j] = obtenerCasilla(correlativo, false, false);
                    } else {
                        tablero[i][j] = obtenerCasilla(correlativo, true, true);
                    }
                } else {
                    if (tablero[i][j] == null) {
                        tablero[i][columnas - 1 - j] = obtenerCasilla(correlativo, false, true); 
                    } else {
                        tablero[i][columnas - 1 - j] = obtenerCasilla(correlativo, true, true);
                    }
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

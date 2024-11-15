package model;

import java.util.Random;

public class Controladora {

    private String[][] tableroTresEnRaya;

    /**
     * Constructor de la clase Controladora para inicializar
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controladora
     */
    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero con valores vacíos.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    /**
     * Devuelve el tablero en formato String.
     */
    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2) sb.append("||");
            }
            sb.append("\n");
            if (i < 2) sb.append("---------\n");
        }
        return sb.toString();
    }

    /**
     * Realiza una jugada aleatoria para la máquina.
     */
    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
    }

    
    public String jugadaPersona(int fila, int columna) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tableroTresEnRaya[fila][columna].equals(" ")) {
            tableroTresEnRaya[fila][columna] = "O";
            return "Jugada en la fila " + fila + " columna " + columna;
        } else {
            return "No valido";
        }
    }

    
    public String verificarGanador() {
        // Verificar filas
        for (int f = 0; f < 3; f++) {
            if (tableroTresEnRaya[f][0].equalsIgnoreCase(tableroTresEnRaya[f][1]) &&
                tableroTresEnRaya[f][1].equalsIgnoreCase(tableroTresEnRaya[f][2]) &&
                !tableroTresEnRaya[f][0].equals(" ")) {
                return "El ganador es " + tableroTresEnRaya[f][0];
            }
        }

        // Verificar columnas
        for (int c = 0; c < 3; c++) {
            if (tableroTresEnRaya[0][c].equalsIgnoreCase(tableroTresEnRaya[1][c]) &&
                tableroTresEnRaya[1][c].equalsIgnoreCase(tableroTresEnRaya[2][c]) &&
                !tableroTresEnRaya[0][c].equals(" ")) {
                return "El winner es: " + tableroTresEnRaya[0][c];
            }
        }

        // Verificar diagonales 1 y 2 (en equis)
        if (tableroTresEnRaya[0][0].equalsIgnoreCase(tableroTresEnRaya[1][1]) &&
            tableroTresEnRaya[1][1].equalsIgnoreCase(tableroTresEnRaya[2][2]) &&
            !tableroTresEnRaya[0][0].equals(" ")) {
            return "El ganador es: " + tableroTresEnRaya[0][0];
        }

        if (tableroTresEnRaya[0][2].equalsIgnoreCase(tableroTresEnRaya[1][1]) &&
            tableroTresEnRaya[1][1].equalsIgnoreCase(tableroTresEnRaya[2][0]) &&
            !tableroTresEnRaya[0][2].equals(" ")) {
            return "El ganador es: " + tableroTresEnRaya[0][2];
        }

        return null; // No ganador todavia
    }
}

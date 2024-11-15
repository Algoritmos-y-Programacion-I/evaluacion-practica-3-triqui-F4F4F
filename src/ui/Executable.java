package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {
        flag = false;

        while (!flag) {
            System.out.println("\n\nBienvenido al menú:\n");
            System.out.println("Opciones:\n" + "1. Imprimir tablero \n" + "2. Jugada de la máquina \n"
                    + "3. Jugada de humano \n" + "4. Verificar ganador \n" + "5. Salir \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.out.println("Chao con adios");
                    break;
                default:
                    System.out.print("Ingrese una opción valida\n");
            }
        }
    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La maquina jugó");
        imprimirTablero();
    }

    private void jugadaHumano() {
        System.out.print("Ingrese la fila (0-2): ");
        int fila = reader.nextInt();
        System.out.print("Ingrese la columna (0-2): ");
        int columna = reader.nextInt();
        reader.nextLine(); 

        String resultadoJugada = cont.jugadaPersona(fila, columna);
        System.out.println(resultadoJugada);
        imprimirTablero();
    }

    private void validarGanador() {
        String ganador = cont.verificarGanador();
        if (ganador == null) {
            System.out.println("No ha terminado el juego");
        } else {
            System.out.println(ganador);
        }
    }
}

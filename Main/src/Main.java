import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] tablero = new char[10][10];

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = '*';
            }
        }

        char robot = 'R';
        tablero[0][0] = robot;
        char casillaFinal = 'F';
        tablero[9][9] = casillaFinal;

        Random rd = new Random();

        int iRd, jRd;
        int counter = 0;
        do {
            iRd = rd.nextInt(10);
            jRd = rd.nextInt(10);
            if (tablero[iRd][jRd] == '*') {
                tablero[iRd][jRd] = 'X';
                counter++;
            }
        } while (counter < 5);

        do {
            iRd = rd.nextInt(10);
            jRd = rd.nextInt(10);
            if (tablero[iRd][jRd] != '*'){
            } else {
                tablero[iRd][jRd] = 'B';
                break;
            }
        } while (true);


        if (tablero[iRd][jRd] == '*' ) {
            tablero[iRd][jRd] = 'B';
        }


        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + "  ");
            }
            System.out.println();
        }

        int contRobot = 0;
        int contFinal = 0;
        int contLibre = 0;
        int contX = 0;
        int contB = 0;
        int total = 0;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                switch (tablero[i][j]) {
                    case 'R' -> {contRobot++;}
                    case 'F' -> {contFinal++;}
                    case 'X' -> {contX++;}
                    case 'B' -> {contB++;}
                    default -> {contLibre++;}
                }
                total++;
            }
        }
        System.out.println("Cantidad de 'R':\f" + contRobot);
        System.out.println("Cantidad de 'F':\f" + contFinal);
        System.out.println("Cantidad de 'X':\f" + contX);
        System.out.println("Cantidad de 'B':\f" + contB);
        System.out.println("Cantidad de casillas libres:\f" + contLibre);
        System.out.println("Cantidad de casillas totales:\f" + total);

        int iPosicion = 0;
        int jPosicion = 0;
        int vidas = 19;
        System.out.println("Misión de rescate preparada");
        System.out.println("Vidas iniciales: " + vidas);

        Scanner sc = new Scanner(System.in);
        char desplazamiento;
        int tempI;
        int tempJ;

        do {
            System.out.println("Tu jugador se encuentra en la casilla" + tablero[iPosicion][jPosicion]);
            System.out.println("Puedes moverte con las teclas WASD.");
            System.out.print("Elige un movimiento: ");
            desplazamiento = sc.next().charAt(0);
            System.out.println("El movimiento elegido es " + desplazamiento);

            tablero[iPosicion][jPosicion] = robot;

            switch (desplazamiento) {
                case 'W':
                    tempI = iPosicion - 1;
                    tempJ = jPosicion - 1;
                    if(tablero[tempI][tempJ] == 'X') break;
                    tablero[iPosicion][jPosicion] = '*';
                    iPosicion--;
                    tablero[iPosicion][jPosicion] = robot;
                    vidas--;
                    break;

                case 'A':
                    tempJ = jPosicion - 1;
                    if(tablero[iPosicion][tempJ] == 'X') break;
                    tablero[iPosicion][jPosicion] = '*';
                    jPosicion--;
                    tablero[iPosicion][jPosicion] = robot;
                    vidas--;
                    break;

                case 'S':
                    tempI = iPosicion + 1;
                    if(tablero[tempI][jPosicion] == 'X') break;
                    tablero[iPosicion][jPosicion] = '*';
                    iPosicion++;
                    tablero[iPosicion][jPosicion] = robot;
                    vidas--;
                    break;

                case 'D':
                    tempI = iPosicion + 1;
                    tempJ = jPosicion + 1;
                    if(tablero[tempI][tempJ] == 'X') break;
                    tablero[iPosicion][jPosicion] = '*';
                    jPosicion++;
                    tablero[iPosicion][jPosicion] = robot;
                    vidas--;
                    break;
            }

            for (int limpiar = 0; limpiar < 50; limpiar++) {
                System.out.println();
            }

            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero.length; j++) {
                    System.out.print(tablero[i][j] + "  ");
                }
                System.out.println();
            }

            if (iPosicion == 9 && jPosicion == 9 || vidas == 0) break;

            System.out.println("Te quedan " + vidas + " vidas");
        } while (true);

        System.out.println("Fin del juego");



    }
}
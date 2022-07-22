package practica_1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Practica_1 {
	

    public static void main(String[] args) throws FileNotFoundException {

    	//Uso de un while para mantener el juego encendido
        int opcionfinal = 0;
        while (opcionfinal < 10) {
            //Bitacora
            int[] bitacora = new int[6];
            //Declaración de matrices de las dificultades y variables necesarias
            //Division de matrices
            int[][] matrizA1 = new int[4][4];
            int[][] matrizB1 = new int[4][4];
            double[][] matrizB0 = new double[4][8];
            double[][] matrizbtotal1 = new double[4][4];
            double[][] resultadofinal1 = new double[4][4];
            double[] resultadofinal1_unadimension = new double[4];
            double[] auxiliarb = new double[8];

            //Suma de matrices
            int[][] matrizA = new int[5][5];
            int[][] matrizB = new int[5][5];
            //Matriz del resultado
            int[][] resultado = new int[5][5];

            //Triangulos
            double ladoA = 0;
            double anguloA = 0;
            double anguloA_rad = 0;
            double anguloA_grados = 0;
            double ladoB = 0;
            double anguloB = 0;
            double anguloB_rad = 0;
            double anguloB_grados = 0;
            double ladoC = 0;
            double anguloC = 0;
            double anguloC_rad = 0;

//variable que acaba con el juego 
            int posicionsuma = 0;
// Textos para el login
            Scanner opcion = new Scanner(System.in);
            Scanner opcion_bucle = new Scanner(System.in);
            String menu = "======MENU PRINCIPAL=======";
            String op1 = "1. Iniciar Juego";
            String op2 = "2. Retomar Juego";
            String op3 = "3. Generar reportes";
            String op4 = "4. Salir";

//Variables de Scanners        
            int opciontotal;

            //scanner para nuevo juego
            Scanner fin = new Scanner(System.in);
            int finopcion;

//Impresión de login
            System.out.println(menu);
            System.out.println(op1);
            System.out.println(op2);
            System.out.println(op3);
            System.out.println(op4);

            opciontotal = opcion.nextInt();

            switch (opciontotal) {
                case 1:

                    System.out.println("Bienvenido al juego, iniciaras en la casilla 1. Suerte");
                    //Variables para movimiento del usuario
                    String[][] usuario = new String[8][8];
                    int[][] espacios = new int[8][8];
                    String[][] espaciostexto = new String[8][8];
                    int[][] espacios1 = new int[8][8];
                    String[][] espaciostexto1 = new String[8][8];
                    int posicion = 0;
                    int impresionposicion;

                    //Retos por sección
                    int reto1 = 0;
                    int reto2 = 0;
                    int reto3 = 0;

                    //Generación de matriz
                    String[][] tablero = new String[8][8];
                    //Generación de castigos a elegir
                    int castigo1 = (int) (Math.random() * 3 + 1);
                    int castigo2 = (int) (Math.random() * 3 + 1);
                    int castigo3 = (int) (Math.random() * 3 + 1);

                    // Numero de castigos por sección de dificultad
                    int numero_castigos1 = (int) (Math.random() * (4 - 2 + 1) + 2);
                    int numero_castigos2 = (int) (Math.random() * (4 - 2 + 1) + 2);
                    int numero_castigos3 = (int) (Math.random() * (4 - 2 + 1) + 2);

                    //Generador de casillas con castigo
                    for (int i = 0; i < numero_castigos1; i++) {
                        int numero_castigo1 = (int) (Math.random() * (6 - 0 + 1) + 0);
                        int numero_castigo_fila = (int) (Math.random() * (7 - 6 + 1) + 6);
                        tablero[numero_castigo_fila][numero_castigo1] = "#";

                    }
                    for (int i = 0; i < numero_castigos2 + 1; i++) {
                        int numero_castigo2 = (int) (Math.random() * (7 - 0 + 1) + 0);
                        int numero_castigo_fila = (int) (Math.random() * (5 - 3 + 1) + 3);
                        tablero[numero_castigo_fila][numero_castigo2] = "#";

                    }

                    for (int i = 0; i < numero_castigos3 + 1; i++) {
                        int numero_castigo3 = (int) (Math.random() * (7 - 0 + 1) + 0);
                        int numero_castigo_fila = (int) (Math.random() * (2 - 0 + 1) + 0);
                        tablero[numero_castigo_fila][numero_castigo3] = "#";
                    }

                    //Creación de reportes solo para que esten inicializados
                    //Creación de reporte
                    FileOutputStream rep = new FileOutputStream("Reporte.html");

                    //Impresion de archivo
                    PrintStream t = new PrintStream(rep);

                    t.println("<html><head><title>Reporte</title></head><body bgcolor = #00b347><h1 align=center><font color = #ffffff >Bienvenido al reporte de la partida ya culminada</h1>");
                    t.print("<h3 align=center>Aquí encontraras todos los cálculos de las penalizaciones donde caíste, podrás visualizar el algoritmo que siguió el programa para realizarlos y por último si este se realizó correctamente o no.</h3><br>");

                    //Creación de bitacora
                    //Se crea el archivo o se modifica
                    FileOutputStream file = new FileOutputStream("Bitácora.pdf");

                    //Impresion de archivo
                    PrintStream p = new PrintStream(file);

                    p.println("<html><head><title>Bitácora</title></head><body bgcolor = #00b347><h1 align=center><font color = #ffffff >Bienvenido a tu Bitacora</h1>");
                    p.print("<h3 align=center>Aquí encontraras todo lo que realices dentro del juego, suerte en tu partida.</h3>");
                    p.print("<br><p align=center>Tu Posición inicial es la casilla 1</p>");

                    //Inicio del bucle del juego
                    while (posicionsuma < 65) {

                        //Variable para activación de reto
                        int reto = 0;
                        bitacora[2] = 0;

                        //Generación del movimientod el usuario
                        if (posicion >= 57) {
                            usuario[0][7 - (posicion - 57)] = "@";
                        } else if (posicion >= 49) {
                            usuario[1][7 - (posicion - 49)] = "@";
                        } else if (posicion >= 41) {
                            usuario[2][7 - (posicion - 41)] = "@";
                        } else if (posicion >= 33) {
                            usuario[3][7 - (posicion - 33)] = "@";
                        } else if (posicion == 25) {
                            usuario[4][7] = "@";
                        } else if (posicion == 24) {
                            usuario[4][7] = "@";
                        } else if (posicion > 25) {
                            usuario[4][7 - (posicion - 25)] = "@";
                        } else if (posicion >= 16) {
                            usuario[5][7 - (posicion - 16)] = "@";
                        } else if (posicion >= 8) {
                            usuario[6][7 - (posicion - 8)] = "@";
                        } else {
                            usuario[7][7 - posicion] = "@";
                        }
                        //Generación de segundo tablero y el cambio de null a solo espacio. De igual manera esta el movimiento del usuario impreso
                        int tablero2[][];
                        tablero2 = new int[8][8];
                        int x = 64;
                        int o = 64;
                        int u = 64;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                espacios[i][j] = o--;
                            }

                        }
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                espacios1[i][j] = u--;
                            }

                        }

                        for (int i = 0; i < tablero2.length; i++) {

                            for (int j = 0; j < tablero2[i].length; j++) {
                                if (espacios1[i][j] == 9 || espacios1[i][j] == 8 || espacios1[i][j] == 7 || espacios1[i][j] == 6 || espacios1[i][j] == 5 || espacios1[i][j] == 4 || espacios1[i][j] == 3 || espacios1[i][j] == 2 || espacios1[i][j] == 1) {
                                    espaciostexto1[i][j] = " ";
                                } else {
                                    espaciostexto1[i][j] = "";
                                }
                                if (espacios[i][j] == 9 || espacios[i][j] == 8 || espacios[i][j] == 7 || espacios[i][j] == 6 || espacios[i][j] == 5 || espacios[i][j] == 4 || espacios[i][j] == 3 || espacios[i][j] == 2 || espacios[i][j] == 1) {
                                    espaciostexto[i][j] = "  ";
                                } else {
                                    espaciostexto[i][j] = "  ";
                                }
                                if (tablero[i][j] == "#") {
                                    if (usuario[i][j] == "@") {
                                        reto = 1;
                                        bitacora[2] = 1;
                                        tablero2[i][j] = x--;
                                    } else {
                                        tablero2[i][j] = x--;
                                        usuario[i][j] = " ";
                                    }

                                } else {
                                    if (usuario[i][j] == "@") {
                                        tablero2[i][j] = x--;
                                        tablero[i][j] = " ";
                                    } else {
                                        tablero2[i][j] = x--;
                                        usuario[i][j] = " ";
                                        tablero[i][j] = " ";
                                    }

                                }
                            }
                        }
                        //Generación del tablero en pantalla
                        for (int i = 0; i < 8; i++) {

                            System.out.println("-----------------------------------------");
                            System.out.println("|" + espaciostexto[i][7] + espaciostexto1[i][7] + tablero2[i][7] + "|" + espaciostexto[i][6] + espaciostexto1[i][6] + tablero2[i][6] + "|" + espaciostexto[i][5] + espaciostexto1[i][5] + tablero2[i][5] + "|" + espaciostexto[i][4] + espaciostexto1[i][4] + tablero2[i][4] + "|" + espaciostexto[i][3] + espaciostexto1[i][3] + tablero2[i][3] + "|" + espaciostexto[i][2] + espaciostexto1[i][2] + tablero2[i][2] + "|" + espaciostexto[i][1] + espaciostexto1[i][1] + tablero2[i][1] + "|" + espaciostexto[i][0] + espaciostexto1[i][0] + tablero2[i][0] + "|\n"
                                    + "|" + usuario[i][7] + espaciostexto[i][7] + tablero[i][7] + "|" + usuario[i][6] + espaciostexto[i][6] + tablero[i][6] + "|" + usuario[i][5] + espaciostexto[i][5] + tablero[i][5] + "|" + usuario[i][4] + espaciostexto[i][4] + tablero[i][4] + "|" + usuario[i][3] + espaciostexto[i][3] + tablero[i][3] + "|" + usuario[i][2] + espaciostexto[i][2] + tablero[i][2] + "|" + usuario[i][1] + espaciostexto[i][1] + tablero[i][1] + "|" + usuario[i][0] + espaciostexto[i][0] + tablero[i][0] + "|");

                            i++;
                            System.out.println("-----------------------------------------");
                            System.out.println("|" + espaciostexto[i][0] + espaciostexto1[i][0] + tablero2[i][0] + "|" + espaciostexto[i][1] + espaciostexto1[i][1] + tablero2[i][1] + "|" + espaciostexto[i][2] + espaciostexto1[i][2] + tablero2[i][2] + "|" + espaciostexto[i][3] + espaciostexto1[i][3] + tablero2[i][3] + "|" + espaciostexto[i][4] + espaciostexto1[i][4] + tablero2[i][4] + "|" + espaciostexto[i][5] + espaciostexto1[i][5] + tablero2[i][5] + "|" + espaciostexto[i][6] + espaciostexto1[i][6] + tablero2[i][6] + "|" + espaciostexto[i][7] + espaciostexto1[i][7] + tablero2[i][7] + "|\n"
                                    + "|" + usuario[i][0] + espaciostexto[i][0] + tablero[i][0] + "|" + usuario[i][1] + espaciostexto[i][1] + tablero[i][1] + "|" + usuario[i][2] + espaciostexto[i][2] + tablero[i][2] + "|" + usuario[i][3] + espaciostexto[i][3] + tablero[i][3] + "|" + usuario[i][4] + espaciostexto[i][5] + tablero[i][4] + "|" + usuario[i][5] + espaciostexto[i][5] + tablero[i][5] + "|" + usuario[i][6] + espaciostexto[i][6] + tablero[i][6] + "|" + usuario[i][7] + espaciostexto[i][7] + tablero[i][7] + "|");

                        }
                        System.out.println("-----------------------------------------");

                        //Reto
                        if (reto == 1) {
                            System.out.println("¡Has caído en una penalización!");

                            if (reto3 < 3 && posicion > 40) {
                                bitacora[3] = 3;
                                switch (castigo3) {
                                    case 1:
                                        bitacora[4] = 1;
                                        System.out.println("Tu castigo es la opción " + castigo3);

                                        //Matriz A
                                        matrizA1[0][0] = 5;
                                        matrizA1[0][1] = 10;
                                        matrizA1[0][2] = 1;
                                        matrizA1[0][3] = 3;
                                        matrizA1[1][0] = 9;
                                        matrizA1[1][1] = 14;
                                        matrizA1[1][2] = 2;
                                        matrizA1[1][3] = 6;
                                        matrizA1[2][0] = 7;
                                        matrizA1[2][1] = 8;
                                        matrizA1[2][2] = 15;
                                        matrizA1[2][3] = 3;
                                        matrizA1[3][0] = 6;
                                        matrizA1[3][1] = 8;
                                        matrizA1[3][2] = 9;
                                        matrizA1[3][3] = 2;

                                        //Matriz B
                                        matrizB1[0][0] = 5;
                                        matrizB1[0][1] = 13;
                                        matrizB1[0][2] = 9;
                                        matrizB1[0][3] = 4;
                                        matrizB1[1][0] = 1;
                                        matrizB1[1][1] = 9;
                                        matrizB1[1][2] = 6;
                                        matrizB1[1][3] = 3;
                                        matrizB1[2][0] = 8;
                                        matrizB1[2][1] = 11;
                                        matrizB1[2][2] = 69;
                                        matrizB1[2][3] = 33;
                                        matrizB1[3][0] = 25;
                                        matrizB1[3][1] = 6;
                                        matrizB1[3][2] = 7;
                                        matrizB1[3][3] = 4;

                                        //Matriz iversa de B con los 0
                                        matrizB0[0][0] = 5;
                                        matrizB0[0][1] = 13;
                                        matrizB0[0][2] = 9;
                                        matrizB0[0][3] = 4;
                                        matrizB0[0][4] = 1;
                                        matrizB0[0][5] = 0;
                                        matrizB0[0][6] = 0;
                                        matrizB0[0][7] = 0;
                                        matrizB0[1][0] = 1;
                                        matrizB0[1][1] = 9;
                                        matrizB0[1][2] = 6;
                                        matrizB0[1][3] = 3;
                                        matrizB0[1][4] = 0;
                                        matrizB0[1][5] = 1;
                                        matrizB0[1][6] = 0;
                                        matrizB0[1][7] = 0;
                                        matrizB0[2][0] = 8;
                                        matrizB0[2][1] = 11;
                                        matrizB0[2][2] = 69;
                                        matrizB0[2][3] = 33;
                                        matrizB0[2][4] = 0;
                                        matrizB0[2][5] = 0;
                                        matrizB0[2][6] = 1;
                                        matrizB0[2][7] = 0;
                                        matrizB0[3][0] = 25;
                                        matrizB0[3][1] = 6;
                                        matrizB0[3][2] = 7;
                                        matrizB0[3][3] = 4;
                                        matrizB0[3][4] = 0;
                                        matrizB0[3][5] = 0;
                                        matrizB0[3][6] = 0;
                                        matrizB0[3][7] = 1;

                                        //Calculos de la matriz inversa
                                        //      Cero [0][0]                              
                                        for (int i = 7; i > -1; i--) {
                                            if (matrizB0[0][0] == 0) {
                                                if (matrizB0[1][0] == 0) {
                                                    if (matrizB0[2][0] == 0) {
                                                        if (matrizB0[3][0] == 0) {
                                                            //esto es si toda la columna es 0
                                                            System.err.println("Tu matriz no es invertible");
                                                            break;
                                                        } // esto es si fila 1,2 y 3 son 0 cambiamos con fila 4
                                                        else {
                                                            for (int j = 0; j < 8; j++) {

                                                                matrizB0[0][j] = auxiliarb[j];
                                                                matrizB0[0][j] = matrizB0[3][j];
                                                                matrizB0[3][j] = auxiliarb[j];
                                                            }
                                                        }
                                                    } //Esto es si fila 1 y 2 son 0 cambiamos con fila 3
                                                    else {
                                                        for (int j = 0; j < 8; j++) {

                                                            matrizB0[0][j] = auxiliarb[j];
                                                            matrizB0[0][j] = matrizB0[2][j];
                                                            matrizB0[2][j] = auxiliarb[j];
                                                        }
                                                    }
                                                } //esto es si fila 1 es 0 la cambiamos con fila 2
                                                else {
                                                    for (int j = 0; j < 8; j++) {

                                                        auxiliarb[j] = matrizB0[0][j];
                                                        matrizB0[0][j] = matrizB0[1][j];
                                                        matrizB0[1][j] = auxiliarb[j];
                                                    }
                                                }
                                            }//Esto es si fila1 no es 0
                                            else {
                                                //dividimos dentro de si misma

                                            }
                                        }
                                        for (int j = 0; j < 8; j++) {
                                            matrizB0[0][7 - j] = matrizB0[0][7 - j] / matrizB0[0][0];
                                        }

                                        for (int i = 7; i > -1; i--) {
                                            // Ceros de [1][0],[2][0] y [3][0]
                                            if (matrizB0[1][0] < 0) {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][0] * matrizB0[0][i]);
                                            } else {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][0] * matrizB0[0][i]);
                                            }

                                            if (matrizB0[2][0] < 0) {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][0] * matrizB0[0][i]);
                                            } else {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][0] * matrizB0[0][i]);
                                            }

                                            if (matrizB0[3][0] < 0) {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][0] * matrizB0[0][i]);
                                            } else {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][0] * matrizB0[0][i]);
                                            }
                                        }

                                        for (int j = 0; j < 8; j++) {
                                            //Cero [1][1]
                                            matrizB0[1][7 - j] = (matrizB0[1][7 - j]) / matrizB0[1][1];
                                        }

                                        for (int i = 7; i > -1; i--) {
                                            //Ceros de [0][1],[2][1] y [3][1]

                                            if (matrizB0[0][1] < 0) {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][1] * matrizB0[1][i]);
                                            } else {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][1] * matrizB0[1][i]);
                                            }

                                            if (matrizB0[2][1] < 0) {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][1] * matrizB0[1][i]);
                                            } else {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][1] * matrizB0[1][i]);
                                            }
                                            if (matrizB0[3][1] < 0) {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][1] * matrizB0[1][i]);
                                            } else {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][1] * matrizB0[1][i]);
                                            }
                                        }

                                        for (int j = 0; j < 8; j++) {
                                            //Cero [2][2]
                                            matrizB0[2][7 - j] = (matrizB0[2][7 - j]) / matrizB0[2][2];
                                        }

                                        //Ceros de [0][2],[1][2] y [3][2]
                                        for (int i = 7; i > -1; i--) {

                                            if (matrizB0[0][2] < 0) {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][2] * matrizB0[2][i]);
                                            } else {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][2] * matrizB0[2][i]);
                                            }
                                            //
                                            if (matrizB0[1][2] < 0) {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][2] * matrizB0[2][i]);
                                            } else {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][2] * matrizB0[2][i]);
                                            }

                                            if (matrizB0[3][2] < 0) {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][2] * matrizB0[2][i]);
                                            } else {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][2] * matrizB0[2][i]);
                                            }
                                        }

                                        for (int j = 0; j < 8; j++) {
                                            //Cero [3][3]
                                            matrizB0[3][7 - j] = (matrizB0[3][7 - j]) / matrizB0[3][3];
                                        }

                                        for (int i = 7; i > -1; i--) {

                                            //Ceros de [0][3],[1][3] y [2][3]
                                            if (matrizB0[0][3] < 0) {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][3] * matrizB0[3][i]);
                                            } else {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][3] * matrizB0[3][i]);
                                            }

                                            if (matrizB0[1][3] < 0) {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][3] * matrizB0[3][i]);
                                            } else {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][3] * matrizB0[3][i]);
                                            }

                                            if (matrizB0[2][3] < 0) {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][3] * matrizB0[3][i]);
                                            } else {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][3] * matrizB0[3][i]);
                                            }
                                        }

                                        //Paso de la matriz inversa a una nueva matriz sin los 0 y 1
                                        for (int i = 0; i < 4; i++) {
                                            for (int j = 0; j < 4; j++) {
                                                matrizbtotal1[i][j] = matrizB0[i][j + 4];
                                            }
                                        }

                                        //Multiplicar la matriz inversa por la mariz A y el resultado colocarlo en una matriz aparte
                                        for (int k = 0; k < 4; k++) {

                                            for (int i = 0; i < matrizA1.length; i++) {
                                                for (int j = 0; j < matrizA1[i].length; j++) {

                                                    resultadofinal1_unadimension[j] = matrizA1[k][j] * matrizbtotal1[j][i];
                                                }

                                                resultadofinal1[k][i] = resultadofinal1_unadimension[0] + resultadofinal1_unadimension[1] + resultadofinal1_unadimension[2] + resultadofinal1_unadimension[3];
                                                resultadofinal1_unadimension[0] = 0;
                                                resultadofinal1_unadimension[1] = 0;
                                                resultadofinal1_unadimension[2] = 0;
                                                resultadofinal1_unadimension[3] = 0;
                                            }
                                        }

                                        //Impresión de resultado
                                        System.out.println("Encontrar la multiplicación de las siguientes matrices:");
                                        System.out.println("-------------");
                                        System.out.println("|" + matrizA1[0][0] + " |" + matrizA1[0][1] + "|" + matrizA1[0][2] + " |" + matrizA1[0][3] + " |");
                                        System.out.println("|" + matrizA1[1][0] + " |" + matrizA1[1][1] + "|" + matrizA1[1][2] + " |" + matrizA1[1][3] + " |");
                                        System.out.println("|" + matrizA1[2][0] + " |" + matrizA1[2][1] + " |" + matrizA1[2][2] + "|" + matrizA1[2][3] + " |");
                                        System.out.println("|" + matrizA1[3][0] + " |" + matrizA1[3][1] + " |" + matrizA1[3][2] + " |" + matrizA1[3][3] + " |");

                                        System.out.println("-------------");
                                        System.out.println("       /  ");
                                        System.out.println("-------------");
                                        System.out.println("|" + matrizB1[0][0] + " |" + matrizB1[0][1] + "|" + matrizB1[0][2] + " |" + matrizB1[0][3] + " |");
                                        System.out.println("|" + matrizB1[1][0] + " |" + matrizB1[1][1] + " |" + matrizB1[1][2] + " |" + matrizB1[1][3] + " |");
                                        System.out.println("|" + matrizB1[2][0] + " |" + matrizB1[2][1] + "|" + matrizB1[2][2] + "|" + matrizB1[2][3] + "|");
                                        System.out.println("|" + matrizB1[3][0] + "|" + matrizB1[3][1] + " |" + matrizB1[3][2] + " |" + matrizB1[3][3] + " |");

                                        System.out.println("-------------");
                                        System.out.println("El resultado es:");

                                        System.out.println("--------------------------------");
                                        System.out.printf("|" + "%.3f", resultadofinal1[0][0]);
                                        System.out.printf(" |" + "%.3f", resultadofinal1[0][1]);
                                        System.out.printf(" | " + "%.3f", resultadofinal1[0][2]);
                                        System.out.printf(" | " + "%.3f", resultadofinal1[0][3]);
                                        System.out.println("|");
                                        System.out.printf("|" + "%.3f", resultadofinal1[1][0]);
                                        System.out.printf(" |" + "%.3f", resultadofinal1[1][1]);
                                        System.out.printf("| " + "%.3f", resultadofinal1[1][2]);
                                        System.out.printf(" | " + "%.3f", resultadofinal1[1][3]);
                                        System.out.println("|");
                                        System.out.printf("| " + "%.3f", resultadofinal1[2][0]);
                                        System.out.printf(" |" + "%.3f", resultadofinal1[2][1]);
                                        System.out.printf("|  " + "%.3f", resultadofinal1[2][2]);
                                        System.out.printf(" |" + "%.3f", resultadofinal1[2][3]);
                                        System.out.println("|");
                                        System.out.printf("| " + "%.3f", resultadofinal1[3][0]);
                                        System.out.printf(" |" + "%.3f", resultadofinal1[3][1]);
                                        System.out.printf("|  " + "%.3f", resultadofinal1[3][2]);
                                        System.out.printf(" |" + "%.3f", resultadofinal1[3][3]);
                                        System.out.println("|");
                                        System.out.println("--------------------------------");
                                        bitacora[5] = 1;
                                        castigo1 = (int) (Math.random() * 2 + 2);
                                        reto3 = ++reto3;

                                        break;

                                    case 2:
                                        bitacora[4] = 2;
                                        System.out.println("Tu castigo es la opción " + castigo3);

                                        //Matriz A
                                        matrizA1[0][0] = 1;
                                        matrizA1[0][1] = 12;
                                        matrizA1[0][2] = 9;
                                        matrizA1[0][3] = 8;
                                        matrizA1[1][0] = 7;
                                        matrizA1[1][1] = 6;
                                        matrizA1[1][2] = 3;
                                        matrizA1[1][3] = 2;
                                        matrizA1[2][0] = 0;
                                        matrizA1[2][1] = 5;
                                        matrizA1[2][2] = 6;
                                        matrizA1[2][3] = 14;
                                        matrizA1[3][0] = 6;
                                        matrizA1[3][1] = 9;
                                        matrizA1[3][2] = 6;
                                        matrizA1[3][3] = 10;

                                        //Matriz B
                                        matrizB1[0][0] = 8;
                                        matrizB1[0][1] = 19;
                                        matrizB1[0][2] = 20;
                                        matrizB1[0][3] = 4;
                                        matrizB1[1][0] = 12;
                                        matrizB1[1][1] = 33;
                                        matrizB1[1][2] = 6;
                                        matrizB1[1][3] = 8;
                                        matrizB1[2][0] = 4;
                                        matrizB1[2][1] = 5;
                                        matrizB1[2][2] = 9;
                                        matrizB1[2][3] = 7;
                                        matrizB1[3][0] = 8;
                                        matrizB1[3][1] = 22;
                                        matrizB1[3][2] = 14;
                                        matrizB1[3][3] = 6;

                                        //Matriz B inversa
                                        matrizB0[0][0] = 8;
                                        matrizB0[0][1] = 19;
                                        matrizB0[0][2] = 20;
                                        matrizB0[0][3] = 4;
                                        matrizB0[0][4] = 1;
                                        matrizB0[0][5] = 0;
                                        matrizB0[0][6] = 0;
                                        matrizB0[0][7] = 0;
                                        matrizB0[1][0] = 12;
                                        matrizB0[1][1] = 33;
                                        matrizB0[1][2] = 6;
                                        matrizB0[1][3] = 8;
                                        matrizB0[1][4] = 0;
                                        matrizB0[1][5] = 1;
                                        matrizB0[1][6] = 0;
                                        matrizB0[1][7] = 0;
                                        matrizB0[2][0] = 4;
                                        matrizB0[2][1] = 5;
                                        matrizB0[2][2] = 9;
                                        matrizB0[2][3] = 7;
                                        matrizB0[2][4] = 0;
                                        matrizB0[2][5] = 0;
                                        matrizB0[2][6] = 1;
                                        matrizB0[2][7] = 0;
                                        matrizB0[3][0] = 8;
                                        matrizB0[3][1] = 22;
                                        matrizB0[3][2] = 14;
                                        matrizB0[3][3] = 6;
                                        matrizB0[3][4] = 0;
                                        matrizB0[3][5] = 0;
                                        matrizB0[3][6] = 0;
                                        matrizB0[3][7] = 1;

                                        //Calculos de la matriz inversa
                                        //      Cero [0][0]                              
                                        for (int i = 7; i > -1; i--) {
                                            if (matrizB0[0][0] == 0) {
                                                if (matrizB0[1][0] == 0) {
                                                    if (matrizB0[2][0] == 0) {
                                                        if (matrizB0[3][0] == 0) {
                                                            //esto es si toda la columna es 0
                                                            System.err.println("Tu matriz no es invertible");
                                                            break;
                                                        } // esto es si fila 1,2 y 3 son 0 cambiamos con fila 4
                                                        else {
                                                            for (int j = 0; j < 8; j++) {

                                                                matrizB0[0][j] = auxiliarb[j];
                                                                matrizB0[0][j] = matrizB0[3][j];
                                                                matrizB0[3][j] = auxiliarb[j];
                                                            }
                                                        }
                                                    } //Esto es si fila 1 y 2 son 0 cambiamos con fila 3
                                                    else {
                                                        for (int j = 0; j < 8; j++) {

                                                            matrizB0[0][j] = auxiliarb[j];
                                                            matrizB0[0][j] = matrizB0[2][j];
                                                            matrizB0[2][j] = auxiliarb[j];
                                                        }
                                                    }
                                                } //esto es si fila 1 es 0 la cambiamos con fila 2
                                                else {
                                                    for (int j = 0; j < 8; j++) {

                                                        auxiliarb[j] = matrizB0[0][j];
                                                        matrizB0[0][j] = matrizB0[1][j];
                                                        matrizB0[1][j] = auxiliarb[j];
                                                    }
                                                }
                                            }//Esto es si fila1 no es 0
                                            else {
                                                //dividimos dentro de si misma

                                            }
                                        }
                                        for (int j = 0; j < 8; j++) {
                                            matrizB0[0][7 - j] = matrizB0[0][7 - j] / matrizB0[0][0];
                                        }

                                        for (int i = 7; i > -1; i--) {
                                            // Ceros de [1][0],[2][0] y [3][0]
                                            if (matrizB0[1][0] < 0) {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][0] * matrizB0[0][i]);
                                            } else {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][0] * matrizB0[0][i]);
                                            }

                                            if (matrizB0[2][0] < 0) {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][0] * matrizB0[0][i]);
                                            } else {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][0] * matrizB0[0][i]);
                                            }

                                            if (matrizB0[3][0] < 0) {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][0] * matrizB0[0][i]);
                                            } else {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][0] * matrizB0[0][i]);
                                            }
                                        }

                                        for (int j = 0; j < 8; j++) {
                                            //Cero [1][1]
                                            matrizB0[1][7 - j] = (matrizB0[1][7 - j]) / matrizB0[1][1];
                                        }

                                        for (int i = 7; i > -1; i--) {
                                            //Ceros de [0][1],[2][1] y [3][1]

                                            if (matrizB0[0][1] < 0) {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][1] * matrizB0[1][i]);
                                            } else {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][1] * matrizB0[1][i]);
                                            }

                                            if (matrizB0[2][1] < 0) {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][1] * matrizB0[1][i]);
                                            } else {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][1] * matrizB0[1][i]);
                                            }
                                            if (matrizB0[3][1] < 0) {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][1] * matrizB0[1][i]);
                                            } else {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][1] * matrizB0[1][i]);
                                            }
                                        }

                                        for (int j = 0; j < 8; j++) {
                                            //Cero [2][2]
                                            matrizB0[2][7 - j] = (matrizB0[2][7 - j]) / matrizB0[2][2];
                                        }

                                        //Ceros de [0][2],[1][2] y [3][2]
                                        for (int i = 7; i > -1; i--) {

                                            if (matrizB0[0][2] < 0) {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][2] * matrizB0[2][i]);
                                            } else {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][2] * matrizB0[2][i]);
                                            }
                                            //
                                            if (matrizB0[1][2] < 0) {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][2] * matrizB0[2][i]);
                                            } else {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][2] * matrizB0[2][i]);
                                            }

                                            if (matrizB0[3][2] < 0) {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][2] * matrizB0[2][i]);
                                            } else {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][2] * matrizB0[2][i]);
                                            }
                                        }

                                        for (int j = 0; j < 8; j++) {
                                            //Cero [3][3]
                                            matrizB0[3][7 - j] = (matrizB0[3][7 - j]) / matrizB0[3][3];
                                        }

                                        for (int i = 7; i > -1; i--) {

                                            //Ceros de [0][3],[1][3] y [2][3]
                                            if (matrizB0[0][3] < 0) {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][3] * matrizB0[3][i]);
                                            } else {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][3] * matrizB0[3][i]);
                                            }

                                            if (matrizB0[1][3] < 0) {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][3] * matrizB0[3][i]);
                                            } else {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][3] * matrizB0[3][i]);
                                            }

                                            if (matrizB0[2][3] < 0) {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][3] * matrizB0[3][i]);
                                            } else {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][3] * matrizB0[3][i]);
                                            }
                                        }

                                        //Paso de la matriz inversa a una nueva matriz sin los 0 y 1
                                        for (int i = 0; i < 4; i++) {
                                            for (int j = 0; j < 4; j++) {
                                                matrizbtotal1[i][j] = matrizB0[i][j + 4];
                                            }
                                        }

                                        for (int k = 0; k < 4; k++) {

                                            for (int i = 0; i < matrizA1.length; i++) {
                                                for (int j = 0; j < matrizA1[i].length; j++) {

                                                    resultadofinal1_unadimension[j] = matrizA1[k][j] * matrizbtotal1[j][i];
                                                }

                                                resultadofinal1[k][i] = resultadofinal1_unadimension[0] + resultadofinal1_unadimension[1] + resultadofinal1_unadimension[2] + resultadofinal1_unadimension[3];
                                                resultadofinal1_unadimension[0] = 0;
                                                resultadofinal1_unadimension[1] = 0;
                                                resultadofinal1_unadimension[2] = 0;
                                                resultadofinal1_unadimension[3] = 0;
                                            }
                                        }

                                        //Impresión de resultado
                                        System.out.println("Encontrar la multiplicación de las siguientes matrices:");
                                        System.out.println("-------------");
                                        System.out.println("|" + matrizA1[0][0] + " |" + matrizA1[0][1] + "|" + matrizA1[0][2] + " |" + matrizA1[0][3] + " |");
                                        System.out.println("|" + matrizA1[1][0] + " |" + matrizA1[1][1] + " |" + matrizA1[1][2] + " |" + matrizA1[1][3] + " |");
                                        System.out.println("|" + matrizA1[2][0] + " |" + matrizA1[2][1] + " |" + matrizA1[2][2] + " |" + matrizA1[2][3] + "|");
                                        System.out.println("|" + matrizA1[3][0] + " |" + matrizA1[3][1] + " |" + matrizA1[3][2] + " |" + matrizA1[3][3] + "|");

                                        System.out.println("-------------");
                                        System.out.println("       /  ");
                                        System.out.println("-------------");
                                        System.out.println("|" + matrizB1[0][0] + " |" + matrizB1[0][1] + "|" + matrizB1[0][2] + "|" + matrizB1[0][3] + " |");
                                        System.out.println("|" + matrizB1[1][0] + "|" + matrizB1[1][1] + "|" + matrizB1[1][2] + " |" + matrizB1[1][3] + " |");
                                        System.out.println("|" + matrizB1[2][0] + " |" + matrizB1[2][1] + " |" + matrizB1[2][2] + " |" + matrizB1[2][3] + " |");
                                        System.out.println("|" + matrizB1[3][0] + " |" + matrizB1[3][1] + "|" + matrizB1[3][2] + "|" + matrizB1[3][3] + " |");

                                        System.out.println("-------------");
                                        System.out.println("El resultado es:");

                                        System.out.println("--------------------------------");
                                        System.out.printf("|" + "%.3f", resultadofinal1[0][0]);
                                        System.out.printf(" |" + "%.3f", resultadofinal1[0][1]);
                                        System.out.printf(" |" + "%.3f", resultadofinal1[0][2]);
                                        System.out.printf(" | " + "%.3f", resultadofinal1[0][3]);
                                        System.out.println("|");
                                        System.out.printf("| " + "%.3f", resultadofinal1[1][0]);
                                        System.out.printf(" |  " + "%.3f", resultadofinal1[1][1]);
                                        System.out.printf("| " + "%.3f", resultadofinal1[1][2]);
                                        System.out.printf(" |" + "%.3f", resultadofinal1[1][3]);
                                        System.out.println("|");
                                        System.out.printf("| " + "%.3f", resultadofinal1[2][0]);
                                        System.out.printf("| " + "%.3f", resultadofinal1[2][1]);
                                        System.out.printf("| " + "%.3f", resultadofinal1[2][2]);
                                        System.out.printf(" | " + "%.3f", resultadofinal1[2][3]);
                                        System.out.println("|");
                                        System.out.printf("|" + "%.3f", resultadofinal1[3][0]);
                                        System.out.printf(" | " + "%.3f", resultadofinal1[3][1]);
                                        System.out.printf(" | " + "%.3f", resultadofinal1[3][2]);
                                        System.out.printf("| " + "%.3f", resultadofinal1[3][3]);
                                        System.out.println("|");
                                        System.out.println("--------------------------------");
                                        castigo3 = 3;
                                        reto3 = ++reto3;
                                        bitacora[5] = 1;

                                        break;
                                    case 3:
                                        bitacora[4] = 3;
                                        System.out.println("Tu castigo es la opción " + castigo3);

                                        //Mariz A
                                        matrizA1[0][0] = 5;
                                        matrizA1[0][1] = 9;
                                        matrizA1[0][2] = 14;
                                        matrizA1[0][3] = 5;
                                        matrizA1[1][0] = 6;
                                        matrizA1[1][1] = 0;
                                        matrizA1[1][2] = 5;
                                        matrizA1[1][3] = 3;
                                        matrizA1[2][0] = 1;
                                        matrizA1[2][1] = 14;
                                        matrizA1[2][2] = 68;
                                        matrizA1[2][3] = 8;
                                        matrizA1[3][0] = 7;
                                        matrizA1[3][1] = 5;
                                        matrizA1[3][2] = 3;
                                        matrizA1[3][3] = 9;

                                        //Matriz B
                                        matrizB1[0][0] = 0;
                                        matrizB1[0][1] = 9;
                                        matrizB1[0][2] = 7;
                                        matrizB1[0][3] = 19;
                                        matrizB1[1][0] = 2;
                                        matrizB1[1][1] = 30;
                                        matrizB1[1][2] = 5;
                                        matrizB1[1][3] = 48;
                                        matrizB1[2][0] = 1;
                                        matrizB1[2][1] = 31;
                                        matrizB1[2][2] = 2;
                                        matrizB1[2][3] = 5;
                                        matrizB1[3][0] = 15;
                                        matrizB1[3][1] = 8;
                                        matrizB1[3][2] = 4;
                                        matrizB1[3][3] = 3;

                                        //Matriz B inversa
                                        matrizB0[0][0] = 0;
                                        matrizB0[0][1] = 9;
                                        matrizB0[0][2] = 7;
                                        matrizB0[0][3] = 19;
                                        matrizB0[0][4] = 1;
                                        matrizB0[0][5] = 0;
                                        matrizB0[0][6] = 0;
                                        matrizB0[0][7] = 0;
                                        matrizB0[1][0] = 2;
                                        matrizB0[1][1] = 30;
                                        matrizB0[1][2] = 5;
                                        matrizB0[1][3] = 48;
                                        matrizB0[1][4] = 0;
                                        matrizB0[1][5] = 1;
                                        matrizB0[1][6] = 0;
                                        matrizB0[1][7] = 0;
                                        matrizB0[2][0] = 1;
                                        matrizB0[2][1] = 31;
                                        matrizB0[2][2] = 2;
                                        matrizB0[2][3] = 5;
                                        matrizB0[2][4] = 0;
                                        matrizB0[2][5] = 0;
                                        matrizB0[2][6] = 1;
                                        matrizB0[2][7] = 0;
                                        matrizB0[3][0] = 15;
                                        matrizB0[3][1] = 8;
                                        matrizB0[3][2] = 4;
                                        matrizB0[3][3] = 3;
                                        matrizB0[3][4] = 0;
                                        matrizB0[3][5] = 0;
                                        matrizB0[3][6] = 0;
                                        matrizB0[3][7] = 1;

                                        //Calculos de la matriz inversa
                                        //Intercambiamos la fila1 con la fila2
                                        matrizB0[1][0] = 0;
                                        matrizB0[1][1] = 9;
                                        matrizB0[1][2] = 7;
                                        matrizB0[1][3] = 19;
                                        matrizB0[1][4] = 1;
                                        matrizB0[1][5] = 0;
                                        matrizB0[1][6] = 0;
                                        matrizB0[1][7] = 0;
                                        matrizB0[0][0] = 2;
                                        matrizB0[0][1] = 30;
                                        matrizB0[0][2] = 5;
                                        matrizB0[0][3] = 48;
                                        matrizB0[0][4] = 0;
                                        matrizB0[0][5] = 1;
                                        matrizB0[0][6] = 0;
                                        matrizB0[0][7] = 0;

                                        //Calculos de la matriz inversa
                                        //      Cero [0][0]                              
                                        for (int i = 7; i > -1; i--) {
                                            if (matrizB0[0][0] == 0) {
                                                if (matrizB0[1][0] == 0) {
                                                    if (matrizB0[2][0] == 0) {
                                                        if (matrizB0[3][0] == 0) {
                                                            //esto es si toda la columna es 0
                                                            System.err.println("Tu matriz no es invertible");
                                                            break;
                                                        } // esto es si fila 1,2 y 3 son 0 cambiamos con fila 4
                                                        else {
                                                            for (int j = 0; j < 8; j++) {

                                                                matrizB0[0][j] = auxiliarb[j];
                                                                matrizB0[0][j] = matrizB0[3][j];
                                                                matrizB0[3][j] = auxiliarb[j];
                                                            }
                                                        }
                                                    } //Esto es si fila 1 y 2 son 0 cambiamos con fila 3
                                                    else {
                                                        for (int j = 0; j < 8; j++) {

                                                            matrizB0[0][j] = auxiliarb[j];
                                                            matrizB0[0][j] = matrizB0[2][j];
                                                            matrizB0[2][j] = auxiliarb[j];
                                                        }
                                                    }
                                                } //esto es si fila 1 es 0 la cambiamos con fila 2
                                                else {
                                                    for (int j = 0; j < 8; j++) {

                                                        auxiliarb[j] = matrizB0[0][j];
                                                        matrizB0[0][j] = matrizB0[1][j];
                                                        matrizB0[1][j] = auxiliarb[j];
                                                    }
                                                }
                                            }//Esto es si fila1 no es 0
                                            else {
                                                //dividimos dentro de si misma

                                            }
                                        }
                                        for (int j = 0; j < 8; j++) {
                                            matrizB0[0][7 - j] = matrizB0[0][7 - j] / matrizB0[0][0];
                                        }

                                        for (int i = 7; i > -1; i--) {
                                            // Ceros de [1][0],[2][0] y [3][0]
                                            if (matrizB0[1][0] < 0) {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][0] * matrizB0[0][i]);
                                            } else {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][0] * matrizB0[0][i]);
                                            }

                                            if (matrizB0[2][0] < 0) {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][0] * matrizB0[0][i]);
                                            } else {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][0] * matrizB0[0][i]);
                                            }

                                            if (matrizB0[3][0] < 0) {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][0] * matrizB0[0][i]);
                                            } else {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][0] * matrizB0[0][i]);
                                            }
                                        }

                                        for (int j = 0; j < 8; j++) {
                                            //Cero [1][1]
                                            matrizB0[1][7 - j] = (matrizB0[1][7 - j]) / matrizB0[1][1];
                                        }

                                        for (int i = 7; i > -1; i--) {
                                            //Ceros de [0][1],[2][1] y [3][1]

                                            if (matrizB0[0][1] < 0) {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][1] * matrizB0[1][i]);
                                            } else {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][1] * matrizB0[1][i]);
                                            }

                                            if (matrizB0[2][1] < 0) {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][1] * matrizB0[1][i]);
                                            } else {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][1] * matrizB0[1][i]);
                                            }
                                            if (matrizB0[3][1] < 0) {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][1] * matrizB0[1][i]);
                                            } else {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][1] * matrizB0[1][i]);
                                            }
                                        }

                                        for (int j = 0; j < 8; j++) {
                                            //Cero [2][2]
                                            matrizB0[2][7 - j] = (matrizB0[2][7 - j]) / matrizB0[2][2];
                                        }

                                        //Ceros de [0][2],[1][2] y [3][2]
                                        for (int i = 7; i > -1; i--) {

                                            if (matrizB0[0][2] < 0) {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][2] * matrizB0[2][i]);
                                            } else {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][2] * matrizB0[2][i]);
                                            }
                                            //
                                            if (matrizB0[1][2] < 0) {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][2] * matrizB0[2][i]);
                                            } else {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][2] * matrizB0[2][i]);
                                            }

                                            if (matrizB0[3][2] < 0) {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][2] * matrizB0[2][i]);
                                            } else {
                                                matrizB0[3][i] = matrizB0[3][i] - (matrizB0[3][2] * matrizB0[2][i]);
                                            }
                                        }

                                        for (int j = 0; j < 8; j++) {
                                            //Cero [3][3]
                                            matrizB0[3][7 - j] = (matrizB0[3][7 - j]) / matrizB0[3][3];
                                        }

                                        for (int i = 7; i > -1; i--) {

                                            //Ceros de [0][3],[1][3] y [2][3]
                                            if (matrizB0[0][3] < 0) {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][3] * matrizB0[3][i]);
                                            } else {
                                                matrizB0[0][i] = matrizB0[0][i] - (matrizB0[0][3] * matrizB0[3][i]);
                                            }

                                            if (matrizB0[1][3] < 0) {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][3] * matrizB0[3][i]);
                                            } else {
                                                matrizB0[1][i] = matrizB0[1][i] - (matrizB0[1][3] * matrizB0[3][i]);
                                            }

                                            if (matrizB0[2][3] < 0) {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][3] * matrizB0[3][i]);
                                            } else {
                                                matrizB0[2][i] = matrizB0[2][i] - (matrizB0[2][3] * matrizB0[3][i]);
                                            }
                                        }

                                        //Paso de la matriz inversa a una nueva matriz sin los 0 y 1
                                        for (int i = 0; i < 4; i++) {
                                            for (int j = 0; j < 4; j++) {
                                                matrizbtotal1[i][j] = matrizB0[i][j + 4];
                                            }
                                        }

                                        //Multiplicación de la matriz
                                        for (int k = 0; k < 4; k++) {

                                            for (int i = 0; i < matrizA1.length; i++) {
                                                for (int j = 0; j < matrizA1[i].length; j++) {

                                                    resultadofinal1_unadimension[j] = matrizA1[k][j] * matrizbtotal1[j][i];
                                                }

                                                resultadofinal1[k][i] = resultadofinal1_unadimension[0] + resultadofinal1_unadimension[1] + resultadofinal1_unadimension[2] + resultadofinal1_unadimension[3];
                                                resultadofinal1_unadimension[0] = 0;
                                                resultadofinal1_unadimension[1] = 0;
                                                resultadofinal1_unadimension[2] = 0;
                                                resultadofinal1_unadimension[3] = 0;
                                            }
                                        }

                                        //Impresión de resultado
                                        System.out.println("Encontrar la multiplicación de las siguientes matrices:");
                                        System.out.println("-------------");
                                        System.out.println("|" + matrizA1[0][0] + " |" + matrizA1[0][1] + " |" + matrizA1[0][2] + "|" + matrizA1[0][3] + " |");
                                        System.out.println("|" + matrizA1[1][0] + " |" + matrizA1[1][1] + " |" + matrizA1[1][2] + " |" + matrizA1[1][3] + " |");
                                        System.out.println("|" + matrizA1[2][0] + " |" + matrizA1[2][1] + "|" + matrizA1[2][2] + "|" + matrizA1[2][3] + " |");
                                        System.out.println("|" + matrizA1[3][0] + " |" + matrizA1[3][1] + " |" + matrizA1[3][2] + " |" + matrizA1[3][3] + " |");

                                        System.out.println("-------------");
                                        System.out.println("       /  ");
                                        System.out.println("-------------");
                                        System.out.println("|" + matrizB1[0][0] + " |" + matrizB1[0][1] + " |" + matrizB1[0][2] + " |" + matrizB1[0][3] + "|");
                                        System.out.println("|" + matrizB1[1][0] + " |" + matrizB1[1][1] + "|" + matrizB1[1][2] + " |" + matrizB1[1][3] + "|");
                                        System.out.println("|" + matrizB1[2][0] + " |" + matrizB1[2][1] + "|" + matrizB1[2][2] + " |" + matrizB1[2][3] + " |");
                                        System.out.println("|" + matrizB1[3][0] + "|" + matrizB1[3][1] + " |" + matrizB1[3][2] + " |" + matrizB1[3][3] + " |");

                                        System.out.println("-------------");
                                        System.out.println("El resultado es:");

                                        System.out.println("--------------------------------");
                                        System.out.printf("| " + "%.3f", resultadofinal1[0][0]);
                                        System.out.printf(" | " + "%.3f", resultadofinal1[0][1]);
                                        System.out.printf("| " + "%.3f", resultadofinal1[0][2]);
                                        System.out.printf(" | " + "%.3f", resultadofinal1[0][3]);
                                        System.out.println("|");
                                        System.out.printf("| " + "%.3f", resultadofinal1[1][0]);
                                        System.out.printf(" | " + "%.3f", resultadofinal1[1][1]);
                                        System.out.printf("| " + "%.3f", resultadofinal1[1][2]);
                                        System.out.printf("| " + "%.3f", resultadofinal1[1][3]);
                                        System.out.println("|");
                                        System.out.printf("| " + "%.3f", resultadofinal1[2][0]);
                                        System.out.printf("| " + "%.3f", resultadofinal1[2][1]);
                                        System.out.printf("| " + "%.3f", resultadofinal1[2][2]);
                                        System.out.printf(" | " + "%.3f", resultadofinal1[2][3]);
                                        System.out.println("|");
                                        System.out.printf("| " + "%.3f", resultadofinal1[3][0]);
                                        System.out.printf(" | " + "%.3f", resultadofinal1[3][1]);
                                        System.out.printf(" | " + "%.3f", resultadofinal1[3][2]);
                                        System.out.printf("| " + "%.3f", resultadofinal1[3][3]);
                                        System.out.println("|");
                                        System.out.println("--------------------------------");
                                        castigo3 = (int) (Math.random() * 2 + 1);
                                        reto3 = ++reto3;
                                        bitacora[5] = 1;
                                        break;
                                }

                            } else if (reto2 < 3 && posicion > 16) {
                                bitacora[3] = 2;
                                switch (castigo2) {

                                    case 1:
                                        bitacora[4] = 1;
                                        System.out.println("Tu castigo es la opción " + castigo2);

                                        //Mariz A
                                        matrizA[0][0] = 7;
                                        matrizA[0][1] = 48;
                                        matrizA[0][2] = 5;
                                        matrizA[0][3] = 0;
                                        matrizA[0][4] = 1;
                                        matrizA[1][0] = 57;
                                        matrizA[1][1] = 8;
                                        matrizA[1][2] = 4;
                                        matrizA[1][3] = 6;
                                        matrizA[1][4] = 14;
                                        matrizA[2][0] = 0;
                                        matrizA[2][1] = 5;
                                        matrizA[2][2] = 6;
                                        matrizA[2][3] = 78;
                                        matrizA[2][4] = 15;
                                        matrizA[3][0] = 21;
                                        matrizA[3][1] = 14;
                                        matrizA[3][2] = 8;
                                        matrizA[3][3] = 19;
                                        matrizA[3][4] = 54;
                                        matrizA[4][0] = 32;
                                        matrizA[4][1] = 20;
                                        matrizA[4][2] = 26;
                                        matrizA[4][3] = 47;
                                        matrizA[4][4] = 12;

                                        //Matriz B
                                        matrizB[0][0] = 9;
                                        matrizB[0][1] = 5;
                                        matrizB[0][2] = 2;
                                        matrizB[0][3] = 1;
                                        matrizB[0][4] = 8;
                                        matrizB[1][0] = 4;
                                        matrizB[1][1] = 2;
                                        matrizB[1][2] = 3;
                                        matrizB[1][3] = 47;
                                        matrizB[1][4] = 8;
                                        matrizB[2][0] = 48;
                                        matrizB[2][1] = 55;
                                        matrizB[2][2] = 32;
                                        matrizB[2][3] = 19;
                                        matrizB[2][4] = 6;
                                        matrizB[3][0] = 7;
                                        matrizB[3][1] = 56;
                                        matrizB[3][2] = 32;
                                        matrizB[3][3] = 14;
                                        matrizB[3][4] = 8;
                                        matrizB[4][0] = 32;
                                        matrizB[4][1] = 87;
                                        matrizB[4][2] = 0;
                                        matrizB[4][3] = 1;
                                        matrizB[4][4] = 7;

                                        //Bucle para suma
                                        for (int i = 0; i < matrizA.length; i++) {
                                            for (int j = 0; j < matrizA[i].length; j++) {
                                                resultado[i][j] = matrizA[i][j] + matrizB[i][j];

                                            }

                                        }
                                        //Impresión de resultado
                                        System.out.println("Encontrar la suma de las siguientes matrices:");
                                        System.out.println("----------------");
                                        System.out.println("|" + matrizA[0][0] + " |" + matrizA[0][1] + "|" + matrizA[0][2] + " |" + matrizA[0][3] + " |" + matrizA[0][4] + " |");
                                        System.out.println("|" + matrizA[1][0] + "|" + matrizA[1][1] + " |" + matrizA[1][2] + " |" + matrizA[1][3] + " |" + matrizA[1][4] + "|");
                                        System.out.println("|" + matrizA[2][0] + " |" + matrizA[2][1] + " |" + matrizA[2][2] + " |" + matrizA[2][3] + "|" + matrizA[2][4] + "|");
                                        System.out.println("|" + matrizA[3][0] + "|" + matrizA[3][1] + "|" + matrizA[3][2] + " |" + matrizA[3][3] + "|" + matrizA[3][4] + "|");
                                        System.out.println("|" + matrizA[4][0] + "|" + matrizA[4][1] + "|" + matrizA[4][2] + "|" + matrizA[4][3] + "|" + matrizA[4][4] + "|");
                                        System.out.println("----------------");
                                        System.out.println("        +  ");
                                        System.out.println("----------------");
                                        System.out.println("|" + matrizB[0][0] + " |" + matrizB[0][1] + " |" + matrizB[0][2] + " |" + matrizB[0][3] + " |" + matrizB[0][4] + "|");
                                        System.out.println("|" + matrizB[1][0] + " |" + matrizB[1][1] + " |" + matrizB[1][2] + " |" + matrizB[1][3] + "|" + matrizB[1][4] + "|");
                                        System.out.println("|" + matrizB[2][0] + "|" + matrizB[2][1] + "|" + matrizB[2][2] + "|" + matrizB[2][3] + "|" + matrizB[2][4] + "|");
                                        System.out.println("|" + matrizB[3][0] + " |" + matrizB[3][1] + "|" + matrizB[3][2] + "|" + matrizB[3][3] + "|" + matrizB[3][4] + "|");
                                        System.out.println("|" + matrizB[4][0] + "|" + matrizB[4][1] + "|" + matrizB[4][2] + " |" + matrizB[4][3] + " |" + matrizB[4][4] + "|");
                                        System.out.println("----------------");
                                        System.out.println("El resultado es:");
                                        System.out.println("--------------------");
                                        System.out.println("|" + resultado[0][0] + " |" + resultado[0][1] + " |" + resultado[0][2] + "  |" + resultado[0][3] + "  |" + resultado[0][4] + " |");
                                        System.out.println("|" + resultado[1][0] + " |" + resultado[1][1] + " |" + resultado[1][2] + "  |" + resultado[1][3] + " |" + resultado[1][4] + "|");
                                        System.out.println("|" + resultado[2][0] + " |" + resultado[2][1] + " |" + resultado[2][2] + " |" + resultado[2][3] + " |" + resultado[2][4] + "|");
                                        System.out.println("|" + resultado[3][0] + " |" + resultado[3][1] + " |" + resultado[3][2] + " |" + resultado[3][3] + " |" + resultado[3][4] + "|");
                                        System.out.println("|" + resultado[4][0] + " |" + resultado[4][1] + "|" + resultado[4][2] + " |" + resultado[4][3] + " |" + resultado[4][4] + "|");
                                        System.out.println("--------------------");
                                        castigo2 = (int) (Math.random() * 2 + 2);
                                        reto2 = ++reto2;
                                        bitacora[5] = 1;
                                        break;

                                    case 2:
                                        bitacora[4] = 2;
                                        System.out.println("Tu castigo es la opción " + castigo2);

                                        //Matriz del resultado
                                        //Matriz A
                                        matrizA[0][0] = 4;
                                        matrizA[0][1] = 9;
                                        matrizA[0][2] = 7;
                                        matrizA[0][3] = 45;
                                        matrizA[0][4] = 18;
                                        matrizA[1][0] = 7;
                                        matrizA[1][1] = 51;
                                        matrizA[1][2] = 26;
                                        matrizA[1][3] = 8;
                                        matrizA[1][4] = 38;
                                        matrizA[2][0] = 48;
                                        matrizA[2][1] = 26;
                                        matrizA[2][2] = 37;
                                        matrizA[2][3] = 21;
                                        matrizA[2][4] = 19;
                                        matrizA[3][0] = 1;
                                        matrizA[3][1] = 0;
                                        matrizA[3][2] = 6;
                                        matrizA[3][3] = 8;
                                        matrizA[3][4] = 1;
                                        matrizA[4][0] = 2;
                                        matrizA[4][1] = 19;
                                        matrizA[4][2] = 55;
                                        matrizA[4][3] = 25;
                                        matrizA[4][4] = 15;

                                        //Matriz B
                                        matrizB[0][0] = 0;
                                        matrizB[0][1] = 15;
                                        matrizB[0][2] = 1;
                                        matrizB[0][3] = 1;
                                        matrizB[0][4] = 66;
                                        matrizB[1][0] = 21;
                                        matrizB[1][1] = 48;
                                        matrizB[1][2] = 7;
                                        matrizB[1][3] = 7;
                                        matrizB[1][4] = 33;
                                        matrizB[2][0] = 4;
                                        matrizB[2][1] = 88;
                                        matrizB[2][2] = 68;
                                        matrizB[2][3] = 68;
                                        matrizB[2][4] = 4;
                                        matrizB[3][0] = 25;
                                        matrizB[3][1] = 18;
                                        matrizB[3][2] = 7;
                                        matrizB[3][3] = 7;
                                        matrizB[3][4] = 55;
                                        matrizB[4][0] = 24;
                                        matrizB[4][1] = 15;
                                        matrizB[4][2] = 5;
                                        matrizB[4][3] = 5;
                                        matrizB[4][4] = 98;

                                        //Generador de la suma
                                        for (int i = 0; i < matrizA.length; i++) {
                                            for (int j = 0; j < matrizA[i].length; j++) {
                                                resultado[i][j] = matrizA[i][j] + matrizB[i][j];

                                            }

                                        }
                                        //Impresión del resultado
                                        System.out.println("Encontrar la suma de las siguientes matrices:");
                                        System.out.println("----------------");
                                        System.out.println("|" + matrizA[0][0] + " |" + matrizA[0][1] + " |" + matrizA[0][2] + " |" + matrizA[0][3] + "|" + matrizA[0][4] + "|");
                                        System.out.println("|" + matrizA[1][0] + " |" + matrizA[1][1] + "|" + matrizA[1][2] + "|" + matrizA[1][3] + " |" + matrizA[1][4] + "|");
                                        System.out.println("|" + matrizA[2][0] + "|" + matrizA[2][1] + "|" + matrizA[2][2] + "|" + matrizA[2][3] + "|" + matrizA[2][4] + "|");
                                        System.out.println("|" + matrizA[3][0] + " |" + matrizA[3][1] + " |" + matrizA[3][2] + " |" + matrizA[3][3] + " |" + matrizA[3][4] + " |");
                                        System.out.println("|" + matrizA[4][0] + " |" + matrizA[4][1] + "|" + matrizA[4][2] + "|" + matrizA[4][3] + "|" + matrizA[4][4] + "|");
                                        System.out.println("----------------");
                                        System.out.println("       +  ");
                                        System.out.println("----------------");
                                        System.out.println("|" + matrizB[0][0] + " |" + matrizB[0][1] + "|" + matrizB[0][2] + " |" + matrizB[0][3] + " |" + matrizB[0][4] + "|");
                                        System.out.println("|" + matrizB[1][0] + "|" + matrizB[1][1] + "|" + matrizB[1][2] + " |" + matrizB[1][3] + " |" + matrizB[1][4] + "|");
                                        System.out.println("|" + matrizB[2][0] + " |" + matrizB[2][1] + "|" + matrizB[2][2] + "|" + matrizB[2][3] + "|" + matrizB[2][4] + " |");
                                        System.out.println("|" + matrizB[3][0] + "|" + matrizB[3][1] + "|" + matrizB[3][2] + " |" + matrizB[3][3] + " |" + matrizB[3][4] + "|");
                                        System.out.println("|" + matrizB[4][0] + "|" + matrizB[4][1] + "|" + matrizB[4][2] + " |" + matrizB[4][3] + " |" + matrizB[4][4] + "|");
                                        System.out.println("----------------");
                                        System.out.println("El resultado es:");
                                        System.out.println("-------------------");
                                        System.out.println("|" + resultado[0][0] + " |" + resultado[0][1] + " |" + resultado[0][2] + "  |" + resultado[0][3] + "|" + resultado[0][4] + " |");
                                        System.out.println("|" + resultado[1][0] + "|" + resultado[1][1] + " |" + resultado[1][2] + " |" + resultado[1][3] + "|" + resultado[1][4] + " |");
                                        System.out.println("|" + resultado[2][0] + "|" + resultado[2][1] + "|" + resultado[2][2] + "|" + resultado[2][3] + "|" + resultado[2][4] + " |");
                                        System.out.println("|" + resultado[3][0] + "|" + resultado[3][1] + " |" + resultado[3][2] + " |" + resultado[3][3] + "|" + resultado[3][4] + " |");
                                        System.out.println("|" + resultado[4][0] + "|" + resultado[4][1] + " |" + resultado[4][2] + " |" + resultado[4][3] + "|" + resultado[4][4] + "|");
                                        System.out.println("-------------------");
                                        castigo1 = 3;
                                        reto2 = ++reto2;
                                        bitacora[5] = 1;
                                        break;

                                    case 3:
                                        bitacora[4] = 3;
                                        System.out.println("Tu castigo es la opción " + castigo2);

                                        //Mariz A
                                        matrizA[0][0] = 0;
                                        matrizA[0][1] = 1;
                                        matrizA[0][2] = 15;
                                        matrizA[0][3] = 5;
                                        matrizA[0][4] = 36;
                                        matrizA[1][0] = 1;
                                        matrizA[1][1] = 78;
                                        matrizA[1][2] = 65;
                                        matrizA[1][3] = 32;
                                        matrizA[1][4] = 4;
                                        matrizA[2][0] = 48;
                                        matrizA[2][1] = 66;
                                        matrizA[2][2] = 39;
                                        matrizA[2][3] = 0;
                                        matrizA[2][4] = 55;
                                        matrizA[3][0] = 14;
                                        matrizA[3][1] = 98;
                                        matrizA[3][2] = 63;
                                        matrizA[3][3] = 20;
                                        matrizA[3][4] = 15;
                                        matrizA[4][0] = 11;
                                        matrizA[4][1] = 39;
                                        matrizA[4][2] = 84;
                                        matrizA[4][3] = 7;
                                        matrizA[4][4] = 1;

                                        //Matriz B
                                        matrizB[0][0] = 78;
                                        matrizB[0][1] = 25;
                                        matrizB[0][2] = 66;
                                        matrizB[0][3] = 48;
                                        matrizB[0][4] = 98;
                                        matrizB[1][0] = 0;
                                        matrizB[1][1] = 45;
                                        matrizB[1][2] = 2;
                                        matrizB[1][3] = 3;
                                        matrizB[1][4] = 1;
                                        matrizB[2][0] = 2;
                                        matrizB[2][1] = 49;
                                        matrizB[2][2] = 14;
                                        matrizB[2][3] = 10;
                                        matrizB[2][4] = 20;
                                        matrizB[3][0] = 35;
                                        matrizB[3][1] = 87;
                                        matrizB[3][2] = 65;
                                        matrizB[3][3] = 2;
                                        matrizB[3][4] = 32;
                                        matrizB[4][0] = 325;
                                        matrizB[4][1] = 8;
                                        matrizB[4][2] = 4;
                                        matrizB[4][3] = 9;
                                        matrizB[4][4] = 39;

                                        //Bucle para suma
                                        for (int i = 0; i < matrizA.length; i++) {
                                            for (int j = 0; j < matrizA[i].length; j++) {
                                                resultado[i][j] = matrizA[i][j] + matrizB[i][j];

                                            }

                                        }
                                        //Impresión de resultado
                                        System.out.println("Encontrar la suma de las siguientes matrices:");
                                        System.out.println("----------------");
                                        System.out.println("|" + matrizA[0][0] + " |" + matrizA[0][1] + " |" + matrizA[0][2] + "|" + matrizA[0][3] + " |" + matrizA[0][4] + "|");
                                        System.out.println("|" + matrizA[1][0] + " |" + matrizA[1][1] + "|" + matrizA[1][2] + "|" + matrizA[1][3] + "|" + matrizA[1][4] + " |");
                                        System.out.println("|" + matrizA[2][0] + "|" + matrizA[2][1] + "|" + matrizA[2][2] + "|" + matrizA[2][3] + " |" + matrizA[2][4] + "|");
                                        System.out.println("|" + matrizA[3][0] + "|" + matrizA[3][1] + "|" + matrizA[3][2] + "|" + matrizA[3][3] + "|" + matrizA[3][4] + "|");
                                        System.out.println("|" + matrizA[4][0] + "|" + matrizA[4][1] + "|" + matrizA[4][2] + "|" + matrizA[4][3] + " |" + matrizA[4][4] + " |");
                                        System.out.println("----------------");
                                        System.out.println("       +  ");
                                        System.out.println("----------------");
                                        System.out.println("|" + matrizB[0][0] + "|" + matrizB[0][1] + "|" + matrizB[0][2] + "|" + matrizB[0][3] + "|" + matrizB[0][4] + "|");
                                        System.out.println("|" + matrizB[1][0] + " |" + matrizB[1][1] + "|" + matrizB[1][2] + " |" + matrizB[1][3] + " |" + matrizB[1][4] + " |");
                                        System.out.println("|" + matrizB[2][0] + " |" + matrizB[2][1] + "|" + matrizB[2][2] + "|" + matrizB[2][3] + "|" + matrizB[2][4] + "|");
                                        System.out.println("|" + matrizB[3][0] + "|" + matrizB[3][1] + "|" + matrizB[3][2] + "|" + matrizB[3][3] + " |" + matrizB[3][4] + "|");
                                        System.out.println("|" + matrizB[4][0] + "|" + matrizB[4][1] + "|" + matrizB[4][2] + " |" + matrizB[4][3] + " |" + matrizB[4][4] + "|");
                                        System.out.println("----------------");
                                        System.out.println("El resultado es:");
                                        System.out.println("--------------------");
                                        System.out.println("|" + resultado[0][0] + " |" + resultado[0][1] + " |" + resultado[0][2] + " |" + resultado[0][3] + "|" + resultado[0][4] + "| ");
                                        System.out.println("|" + resultado[1][0] + "  |" + resultado[1][1] + "|" + resultado[1][2] + " |" + resultado[1][3] + "|" + resultado[1][4] + "  |");
                                        System.out.println("|" + resultado[2][0] + " |" + resultado[2][1] + "|" + resultado[2][2] + " |" + resultado[2][3] + "|" + resultado[2][4] + " |");
                                        System.out.println("|" + resultado[3][0] + " |" + resultado[3][1] + "|" + resultado[3][2] + "|" + resultado[3][3] + "|" + resultado[3][4] + " |");
                                        System.out.println("|" + resultado[4][0] + "|" + resultado[4][1] + " |" + resultado[4][2] + " |" + resultado[4][3] + "|" + resultado[4][4] + " |");
                                        System.out.println("--------------------");
                                        castigo2 = (int) (Math.random() * 2 + 1);
                                        reto2 = ++reto2;
                                        bitacora[5] = 1;
                                        break;
                                }

                            } else if (reto1 < 3 && posicion >= 0) {
                                bitacora[3] = 1;

                                switch (castigo1) {
                                    case 1:
                                        bitacora[4] = 1;
                                        //Imprimir operacion
                                        System.out.println("Tu castigo es la opción " + castigo1);

                                        System.out.println("Valores dados:");
                                        System.out.println("Lado A = 15");
                                        System.out.println("Lado C = 20");
                                        System.out.println("Angulo B = 25");
                                        System.out.println("Encontrar el lado B y los ángulos de A y C");
                                        System.out.println("-------------------------------------------");
                                        //Calculo del primer triangulo
                                        System.out.println("Resultado:");
                                        ladoA = 15;
                                        ladoC = 20;
                                        anguloB = 25;
                                        anguloB_rad = Math.toRadians(25);
                                        ladoB = Math.sqrt(((ladoA) * (ladoA)) + ((ladoC) * (ladoC)) - (2 * ladoA * ladoC * (Math.cos(anguloB_rad))));
                                        anguloA = Math.acos(((-(ladoC) * (ladoC)) + ((ladoA) * (ladoA)) - ((ladoB) * (ladoB))) / (-2 * ladoA * ladoB));
                                        anguloA_grados = Math.toDegrees(anguloA);
                                        anguloC = 180 - anguloB - anguloA_grados;
                                        System.out.printf("Los calculos creados por el programa son: ");
                                        System.out.printf("\n" + "Lado_A= " + "%.3f" + "\n", ladoA);
                                        System.out.printf("Lado_B= " + "%.3f" + "\n", ladoB);
                                        System.out.printf("Lado_C= " + "%.3f" + "\n", ladoC);
                                        System.out.printf("Angulo_A= " + "%.3f" + "\n", anguloA_grados);
                                        System.out.printf("Angulo_B= " + "%.3f" + "\n", anguloB);
                                        System.out.printf("Angulo_C= " + "%.3f" + "\n", anguloC);
                                        castigo1 = (int) (Math.random() * 2 + 2);
                                        reto1 = reto + 1;
                                        bitacora[5] = 1;
                                        break;

                                    case 2:
                                        bitacora[4] = 2;
                                        //Imprimir operacion
                                        System.out.println("Tu castigo es la opción " + castigo1);

                                        System.out.println("Valores dados:");
                                        System.out.println("Lado B = 10");
                                        System.out.println("Lado C = 25");
                                        System.out.println("Angulo A = 30");
                                        System.out.println("Encontrar el lado A y los ángulos de B y C");
                                        System.out.println("-------------------------------------------");

                                        //Calculo del segundo triangulo
                                        ladoC = 25;
                                        ladoB = 10;
                                        anguloA = 30;
                                        anguloA_rad = Math.toRadians(anguloA);
                                        ladoA = Math.sqrt(((ladoB) * (ladoB)) + ((ladoC) * (ladoC)) - (2 * ladoB * ladoC * (Math.cos(anguloA_rad))));
                                        anguloA_rad = Math.toRadians(anguloA);
                                        ladoA = Math.sqrt(((ladoB) * (ladoB)) + ((ladoC) * (ladoC)) - (2 * ladoB * ladoC * (Math.cos(anguloA_rad))));
                                        anguloB = Math.acos((-((ladoC) * (ladoC)) - ((ladoA) * (ladoA)) + ((ladoB) * (ladoB))) / (-2 * ladoA * ladoC));
                                        anguloB_grados = Math.toDegrees(anguloB);
                                        anguloC = 180 - anguloA - anguloB_grados;
                                        System.out.printf("Los calculos creados por el programa son: ");
                                        System.out.printf("\n" + "Lado_A= " + "%.3f" + "\n", ladoA);
                                        System.out.printf("Lado_B= " + "%.3f" + "\n", ladoB);
                                        System.out.printf("Lado_C= " + "%.3f" + "\n", ladoC);
                                        System.out.printf("Angulo_A= " + "%.3f" + "\n", anguloA);
                                        System.out.printf("Angulo_B= " + "%.3f" + "\n", anguloB_grados);
                                        System.out.printf("Angulo_C= " + "%.3f" + "\n", anguloC);
                                        castigo1 = 3;
                                        reto1 = reto + 1;
                                        bitacora[5] = 1;
                                        break;
                                    case 3:
                                        bitacora[4] = 3;
                                        //Imprimir operacion
                                        System.out.println("Tu castigo es la opción " + castigo1);

                                        System.out.println("Valores dados:");
                                        System.out.println("Lado A = 18");
                                        System.out.println("Lado B = 25");
                                        System.out.println("Angulo C = 30");
                                        System.out.println("Encontrar el lado C y los ángulos de B y A");
                                        System.out.println("-------------------------------------------");

                                        //Calculo del tercer triangulo
                                        System.out.println("Tu castigo es la opción " + castigo1);
                                        ladoA = 18;
                                        ladoB = 15;
                                        anguloC = 30;
                                        anguloC_rad = Math.toRadians(anguloC);
                                        ladoC = Math.sqrt(((ladoB) * (ladoB)) + ((ladoA) * (ladoA)) - (2 * ladoB * ladoA * (Math.cos(anguloC_rad))));
                                        anguloA = Math.acos((-((ladoC) * (ladoC)) + ((ladoA) * (ladoA)) - ((ladoB) * (ladoB))) / (-2 * ladoB * ladoC));
                                        anguloA_grados = Math.toDegrees(anguloA);
                                        anguloB = 180 - anguloC - anguloA_grados;
                                        System.out.printf("Los calculos creados por el programa son: ");
                                        System.out.printf("\n" + "Lado_A= " + "%.3f" + "\n", ladoA);
                                        System.out.printf("Lado_B= " + "%.3f" + "\n", ladoB);
                                        System.out.printf("Lado_C= " + "%.3f" + "\n", ladoC);
                                        System.out.printf("Angulo_A= " + "%.3f" + "\n", anguloA_grados);
                                        System.out.printf("Angulo_B= " + "%.3f" + "\n", anguloB);
                                        System.out.printf("Angulo_C= " + "%.3f" + "\n", anguloC);
                                        castigo1 = (int) (Math.random() * 2 + 1);
                                        reto1 = reto + 1;
                                        bitacora[5] = 1;
                                        break;
                                }
                            } else {
                                System.out.println("Ya tomaste caíste dos veces en la misma dificultad de penalizaciones, sigue jugando");

                            }
                        }

                        //Reinicio de tablero para mostrar la nueva posición del usuario
                        for (int i = 0; i < usuario.length; i++) {
                            for (int j = 0; j < usuario[i].length; j++) {
                                usuario[i][j] = "";
                            }
                        }
                        //Generación del dado para el siguiente turno
                        int dadosrandom = (int) (Math.random() * 5 + 2);
                        System.out.println("¿Qué deseas hacer? Escribe p si deseas al menu. Por lo contrario si deseas lanzar el siguiente dado presiona r");
                        String preguntabucle = opcion_bucle.nextLine();
                        switch (preguntabucle) {

                            case "r":

                                System.out.println("Tu dado fue lanzado... a caído: " + dadosrandom);
                                bitacora[0] = dadosrandom;
                                posicion = posicion + dadosrandom;

                                impresionposicion = posicion + 1;
                                bitacora[1] = impresionposicion;

                                //Impresión de la bitacora
                                if (bitacora[2] == 0) {
                                    p.print("<br><p align=center>Tus dados en este turno fueron: " + bitacora[0] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                    p.print("Tu nueva posición es la casilla: " + bitacora[1] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                    p.print("No caíste en penalización</p>");

                                } else {
                                    switch (bitacora[3]) {
                                        case 1:
                                            p.print("<br><p align=center>Tus dados en este turno fueron: " + bitacora[0] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                            p.print("Tu nueva posición es la casilla: " + bitacora[1] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                            p.print("¡Caíste en una penalización!</p>");
                                            p.print("<br><p align=center>Tu castigo fue una operación fácil&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                            p.print("Toco la opción: " + bitacora[4] + "</p><br>");

                                            break;
                                        case 2:
                                            p.print("<br><p align=center>Tus dados en este turno fueron: " + bitacora[0] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                            p.print("Tu nueva posición es la casilla: " + bitacora[1] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                            p.print("¡Caíste en una penalización!</p>");
                                            p.print("<br><p align=center>Tu castigo fue una operación intermedia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                            p.print("Toco la opción: " + bitacora[4] + "</p><br>");

                                            break;
                                        case 3:
                                            p.print("<br><p align=center>Tus dados en este turno fueron: " + bitacora[0] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                            p.print("Tu nueva posición es la casilla: " + bitacora[1] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                            p.print("¡Caíste en una penalización!</p>");
                                            p.print("<br><p align=center>Tu castigo fue una operación dificil&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                            p.print("Toco la opción: " + bitacora[4] + "</p><br>");

                                            break;

                                    }

                                }
                                //Impresión de reporte

                                if (bitacora[2] == 1) {
                                    switch (bitacora[3]) {
                                        case 1:
                                            switch (bitacora[4]) {
                                                case 1:
                                                    t.print("<br><p align=center>Tu castigo fue una operación fácil&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                    t.print("<p align=center>Se nos proporciona el lado A con valor: " + ladoA + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Se nos proporciona el lado C con valor: " + ladoC + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("y un angulo B de valor: " + anguloB + "</p>");
                                                    t.print("<br><p align=center>Necesitamos encontrar el lado y los ángulos restantes</p>");
                                                    t.print("<br><p align=center>Convertimos el Angulo " + anguloB + " a radianes ya que Math.cos trabaja con ángulos en radianes.</p><br>");
                                                    t.print("<p align=center>Utilizando Math.toRadians transformamos y nos da como resultado: " + anguloB_rad + "</p><br>");
                                                    t.print("<p align=center>Para calcular el lado faltante utilizamos ley de coseno, sacaremos la raíz cuadrada de   A^2 + C^2 -2*A*C*cos" + anguloB + "</p><br>");
                                                    t.print("<p align=center>Utilizando Math.sqrt(((ladoA) * (ladoA)) + ((ladoC) * (ladoC)) - (2 * ladoA * ladoC * (Math.cos(anguloB_rad)))) obtenemos: " + ladoB + "</p><br>");
                                                    t.print("<p align=center>Para calcular el primer angulo faltante utilizamos ley de coseno nuevamente, calculando el arccoseno de   (-A^2 - C^2 + B^2)/-2*A*C</p><br>");
                                                    t.print("<p align=center>Utilizando Math.acos(((-(ladoC) * (ladoC)) + ((ladoA) * (ladoA)) - ((ladoB) * (ladoB))) / (-2 * ladoA * ladoB)) obtenemos: " + anguloA + "</p><br>");
                                                    t.print("<p align=center>Convertimos el Angulo " + anguloA + " a grados ya que los demas estan en grados.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Utilizando Math.toDegrees obtenemos: " + anguloA_grados + "</p>");
                                                    t.print("<br><p align=center>Para el angulo faltante, realizamos 180 - " + anguloB + " - " + anguloA_grados + " y esto nos da: " + anguloC + "</p>");
                                                    t.print("<br><p align=center >Los resultados totales son:</p>");
                                                    t.format("<br><p align=center >Lado A= " + "%.3f" + "\n", ladoA);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lado B= " + "%.3f" + "\n", ladoB);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lado C= " + "%.3f" + "\n", ladoC);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo A= " + "%.3f" + "\n", anguloA_grados);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo B= " + "%.3f" + "\n", anguloB);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo C= " + "%.3f" + "\n", anguloC);
                                                    t.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tu cálculo fue: " + bitacora[5] + "</p><br>");
                                                    t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                    break;
                                                case 2:
                                                    t.print("<br><p align=center>Tu castigo fue una operación fácil&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                    t.print("<p align=center>Se nos proporciona el lado C con valor: " + ladoC + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Se nos proporciona el lado B con valor: " + ladoB + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("y un angulo A de valor: " + anguloA + "</p>");
                                                    t.print("<br><p align=center>Necesitamos encontrar el lado y los ángulos restantes</p>");
                                                    t.print("<br><p align=center>Convertimos el Angulo " + anguloA + " a radianes ya que Math.cos trabaja con ángulos en radianes.</p><br>");
                                                    t.print("<p align=center>Utilizando Math.toRadians transformamos y nos da como resultado: " + anguloA_rad + "</p><br>");
                                                    t.print("<p align=center>Para calcular el lado faltante utilizamos ley de coseno, sacaremos la raíz cuadrada de   B^2 + C^2 -2*B*C*cos" + anguloA_rad + "</p><br>");
                                                    t.print("<p align=center>Utilizando Math.sqrt(((ladoB) * (ladoB)) + ((ladoC) * (ladoC)) - (2 * ladoB * ladoC * (Math.cos(anguloA_rad)))) obtenemos: " + ladoA + "</p><br>");
                                                    t.print("<p align=center>Para calcular el primer angulo faltante utilizamos ley de coseno nuevamente, calculando el arccoseno de   (A^2 - C^2 - B^2)/-2*B*C</p><br>");
                                                    t.print("<p align=center>Utilizando Math.acos((-((ladoC) * (ladoC)) - ((ladoA) * (ladoA)) + ((ladoB) * (ladoB))) / (-2 * ladoA * ladoC)) obtenemos: " + anguloB + "</p><br>");
                                                    t.print("<p align=center>Convertimos el Angulo " + anguloB + " a grados ya que los demas estan en grados.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Utilizando Math.toDegrees obtenemos: " + anguloB_grados + "</p>");
                                                    t.print("<br><p align=center>Para el angulo faltante, realizamos 180 - " + anguloA + " - " + anguloB_grados + " y esto nos da: " + anguloC + "</p>");
                                                    t.print("<br><p align=center >Los resultados totales son:</p>");
                                                    t.format("<br><p align=center >Lado A= " + "%.3f" + "\n", ladoA);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lado B= " + "%.3f" + "\n", ladoB);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lado C= " + "%.3f" + "\n", ladoC);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo A= " + "%.3f" + "\n", anguloA);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo B= " + "%.3f" + "\n", anguloB_grados);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo C= " + "%.3f" + "\n", anguloC);
                                                    t.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tu cálculo fue: " + bitacora[5] + "</p><br>");
                                                    t.print("<br><p align=center >=====================================================================================================================================</p>");

                                                    break;
                                                case 3:
                                                    t.print("<br><p align=center>Tu castigo fue una operación fácil&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                    t.print("<p align=center>Se nos proporciona el lado A con valor: " + ladoA + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Se nos proporciona el lado B con valor: " + ladoB + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("y un angulo C de valor: " + anguloC + "</p>");
                                                    t.print("<br><p align=center>Necesitamos encontrar el lado y los ángulos restantes</p>");
                                                    t.print("<br><p align=center>Convertimos el Angulo " + anguloC + " a radianes ya que Math.cos trabaja con ángulos en radianes.</p><br>");
                                                    t.print("<p align=center>Utilizando Math.toRadians transformamos y nos da como resultado: " + anguloC_rad + "</p><br>");
                                                    t.print("<p align=center>Para calcular el lado faltante utilizamos ley de coseno, sacaremos la raíz cuadrada de   B^2 + A^2 -2*A*B*cos" + anguloC_rad + "</p><br>");
                                                    t.print("<p align=center>Utilizando  Math.sqrt(((ladoB) * (ladoB)) + ((ladoA) * (ladoA)) - (2 * ladoB * ladoA * (Math.cos(anguloC_rad)))) obtenemos: " + ladoC + "</p><br>");
                                                    t.print("<p align=center>Para calcular el primer angulo faltante utilizamos ley de coseno nuevamente, calculando el arccoseno de   (-A^2 + C^2 - B^2)/-2*A*B</p><br>");
                                                    t.print("<p align=center>Utilizando Math.acos((-((ladoC) * (ladoC)) + ((ladoA) * (ladoA)) - ((ladoB) * (ladoB))) / (-2 * ladoB * ladoC)) obtenemos: " + anguloA + "</p><br>");
                                                    t.print("<p align=center>Convertimos el Angulo " + anguloA + " a grados ya que los demas estan en grados.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Utilizando Math.toDegrees obtenemos: " + anguloA_grados + "</p>");
                                                    t.print("<br><p align=center>Para el angulo faltante, realizamos 180 - " + anguloC + " - " + anguloA_grados + " y esto nos da: " + anguloB + "</p>");
                                                    t.print("<br><p align=center >Los resultados totales son:</p>");
                                                    t.format("<br><p align=center >Lado A= " + "%.3f" + "\n", ladoA);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lado B= " + "%.3f" + "\n", ladoB);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lado C= " + "%.3f" + "\n", ladoC);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo A= " + "%.3f" + "\n", anguloA_grados);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo B= " + "%.3f" + "\n", anguloB);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo C= " + "%.3f" + "\n", anguloC);
                                                    t.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tu cálculo fue: " + bitacora[5] + "</p><br>");
                                                    t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                    break;

                                            }

                                            break;
                                        case 2:
                                            switch (bitacora[4]) {
                                                case 1:
                                                    t.print("<br><p align=center>Tu castigo fue una operación intermedia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                    t.print("<p align=center >Tu operación corresponde a la suma de las siguientes matrices: </p><br>");
                                                    t.print("<p align=center>|" + matrizA[0][0] + " |" + matrizA[0][1] + "|" + matrizA[0][2] + " |" + matrizA[0][3] + " |" + matrizA[0][4] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[0][0] + " |" + matrizB[0][1] + " |" + matrizB[0][2] + " |" + matrizB[0][3] + " |" + matrizB[0][4] + "|<br>");
                                                    t.print("|" + matrizA[1][0] + "|" + matrizA[1][1] + " |" + matrizA[1][2] + " |" + matrizA[1][3] + " |" + matrizA[1][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[1][0] + " |" + matrizB[1][1] + " |" + matrizB[1][2] + " |" + matrizB[1][3] + "|" + matrizB[1][4] + "|<br>");
                                                    t.print("|" + matrizA[2][0] + " |" + matrizA[2][1] + " |" + matrizA[2][2] + " |" + matrizA[2][3] + "|" + matrizA[2][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[2][0] + "|" + matrizB[2][1] + "|" + matrizB[2][2] + "|" + matrizB[2][3] + "|" + matrizB[2][4] + "|<br>");
                                                    t.print("|" + matrizA[3][0] + "|" + matrizA[3][1] + "|" + matrizA[3][2] + " |" + matrizA[3][3] + "|" + matrizA[3][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[3][0] + " |" + matrizB[3][1] + "|" + matrizB[3][2] + "|" + matrizB[3][3] + "|" + matrizB[3][4] + "|<br>");
                                                    t.print("|" + matrizA[4][0] + "|" + matrizA[4][1] + "|" + matrizA[4][2] + "|" + matrizA[4][3] + "|" + matrizA[4][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[4][0] + "|" + matrizB[4][1] + "|" + matrizB[4][2] + " |" + matrizB[4][3] + " |" + matrizB[4][4] + "|</p><br>");
                                                    t.print("<p align=center >Lo que se realizo fue sumar cada posición de cada matriz y ese resultado colocarlo en una matriz llamada resultado<br><br><br>");
                                                    t.print("int[][] resultado = new int[5][5];</p><br>");

                                                    t.print("<p align=center >Para optimizar el código se utilizó dos ciclos for recorriendo toda la matriz A y asi poder sumar todos los datos.<br><br><br>");
                                                    t.print("for (int i = 0; i < matrizA.length; i++) {<br>");
                                                    t.print("for (int j = 0; j < matrizA[i].length; j++) {<br>");
                                                    t.print(" resultado [i][j] = matrizA[i][j]+matrizB[i][j];}}</p><br>");
                                                    t.print("<p align=center > Y con esto obtenemos: </p><br>");

                                                    t.print("<p align=center >|" + resultado[0][0] + " |" + resultado[0][1] + " |" + resultado[0][2] + "  |" + resultado[0][3] + "  |" + resultado[0][4] + " |<br>");
                                                    t.print("|" + resultado[1][0] + " |" + resultado[1][1] + " |" + resultado[1][2] + "  |" + resultado[1][3] + " |" + resultado[1][4] + "|<br>");
                                                    t.print("|" + resultado[2][0] + " |" + resultado[2][1] + " |" + resultado[2][2] + " |" + resultado[2][3] + " |" + resultado[2][4] + "|<br>");
                                                    t.print("|" + resultado[3][0] + " |" + resultado[3][1] + " |" + resultado[3][2] + " |" + resultado[3][3] + " |" + resultado[3][4] + "|<br>");
                                                    t.print("|" + resultado[4][0] + " |" + resultado[4][1] + "|" + resultado[4][2] + " |" + resultado[4][3] + " |" + resultado[4][4] + "|<br>");
                                                    t.print("<p align=center>Tu cálculo fue: " + bitacora[5] + "</p><br>");
                                                    t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                    t.format("</p>");
                                                    break;
                                                case 2:
                                                    t.print("<br><p align=center>Tu castigo fue una operación intermedia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                    t.print("<p align=center >Tu operación corresponde a la suma de las siguientes matrices: </p><br>");
                                                    t.print("<p align=center>|" + matrizA[0][0] + " |" + matrizA[0][1] + "|" + matrizA[0][2] + " |" + matrizA[0][3] + " |" + matrizA[0][4] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[0][0] + " |" + matrizB[0][1] + " |" + matrizB[0][2] + " |" + matrizB[0][3] + " |" + matrizB[0][4] + "|<br>");
                                                    t.print("|" + matrizA[1][0] + "|" + matrizA[1][1] + " |" + matrizA[1][2] + " |" + matrizA[1][3] + " |" + matrizA[1][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[1][0] + " |" + matrizB[1][1] + " |" + matrizB[1][2] + " |" + matrizB[1][3] + "|" + matrizB[1][4] + "|<br>");
                                                    t.print("|" + matrizA[2][0] + " |" + matrizA[2][1] + " |" + matrizA[2][2] + " |" + matrizA[2][3] + "|" + matrizA[2][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[2][0] + "|" + matrizB[2][1] + "|" + matrizB[2][2] + "|" + matrizB[2][3] + "|" + matrizB[2][4] + "|<br>");
                                                    t.print("|" + matrizA[3][0] + "|" + matrizA[3][1] + "|" + matrizA[3][2] + " |" + matrizA[3][3] + "|" + matrizA[3][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[3][0] + " |" + matrizB[3][1] + "|" + matrizB[3][2] + "|" + matrizB[3][3] + "|" + matrizB[3][4] + "|<br>");
                                                    t.print("|" + matrizA[4][0] + "|" + matrizA[4][1] + "|" + matrizA[4][2] + "|" + matrizA[4][3] + "|" + matrizA[4][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[4][0] + "|" + matrizB[4][1] + "|" + matrizB[4][2] + " |" + matrizB[4][3] + " |" + matrizB[4][4] + "|</p><br>");
                                                    t.print("<p align=center >Lo que se realizo fue sumar cada posición de cada matriz y ese resultado colocarlo en una matriz llamada resultado<br><br><br>");
                                                    t.print("int[][] resultado = new int[5][5];</p><br>");

                                                    t.print("<p align=center >Para optimizar el código se utilizó dos ciclos for recorriendo toda la matriz A y asi poder sumar todos los datos.<br><br><br>");
                                                    t.print("for (int i = 0; i < matrizA.length; i++) {<br>");
                                                    t.print("for (int j = 0; j < matrizA[i].length; j++) {<br>");
                                                    t.print(" resultado [i][j] = matrizA[i][j]+matrizB[i][j];}}</p><br>");
                                                    t.print("<p align=center > Y con esto obtenemos: </p><br>");

                                                    t.print("<p align=center >|" + resultado[0][0] + " |" + resultado[0][1] + " |" + resultado[0][2] + "  |" + resultado[0][3] + "  |" + resultado[0][4] + " |<br>");
                                                    t.print("|" + resultado[1][0] + " |" + resultado[1][1] + " |" + resultado[1][2] + "  |" + resultado[1][3] + " |" + resultado[1][4] + "|<br>");
                                                    t.print("|" + resultado[2][0] + " |" + resultado[2][1] + " |" + resultado[2][2] + " |" + resultado[2][3] + " |" + resultado[2][4] + "|<br>");
                                                    t.print("|" + resultado[3][0] + " |" + resultado[3][1] + " |" + resultado[3][2] + " |" + resultado[3][3] + " |" + resultado[3][4] + "|<br>");
                                                    t.print("|" + resultado[4][0] + " |" + resultado[4][1] + "|" + resultado[4][2] + " |" + resultado[4][3] + " |" + resultado[4][4] + "|<br>");
                                                    t.print("<p align=center>Tu cálculo fue: " + bitacora[5] + "</p><br>");
                                                    t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                    t.format("</p>");

                                                    break;
                                                case 3:
                                                    t.print("<br><p align=center>Tu castigo fue una operación intermedia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                    t.print("<p align=center >Tu operación corresponde a la suma de las siguientes matrices: </p><br>");
                                                    t.print("<p align=center>|" + matrizA[0][0] + " |" + matrizA[0][1] + "|" + matrizA[0][2] + " |" + matrizA[0][3] + " |" + matrizA[0][4] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[0][0] + " |" + matrizB[0][1] + " |" + matrizB[0][2] + " |" + matrizB[0][3] + " |" + matrizB[0][4] + "|<br>");
                                                    t.print("|" + matrizA[1][0] + "|" + matrizA[1][1] + " |" + matrizA[1][2] + " |" + matrizA[1][3] + " |" + matrizA[1][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[1][0] + " |" + matrizB[1][1] + " |" + matrizB[1][2] + " |" + matrizB[1][3] + "|" + matrizB[1][4] + "|<br>");
                                                    t.print("|" + matrizA[2][0] + " |" + matrizA[2][1] + " |" + matrizA[2][2] + " |" + matrizA[2][3] + "|" + matrizA[2][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[2][0] + "|" + matrizB[2][1] + "|" + matrizB[2][2] + "|" + matrizB[2][3] + "|" + matrizB[2][4] + "|<br>");
                                                    t.print("|" + matrizA[3][0] + "|" + matrizA[3][1] + "|" + matrizA[3][2] + " |" + matrizA[3][3] + "|" + matrizA[3][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[3][0] + " |" + matrizB[3][1] + "|" + matrizB[3][2] + "|" + matrizB[3][3] + "|" + matrizB[3][4] + "|<br>");
                                                    t.print("|" + matrizA[4][0] + "|" + matrizA[4][1] + "|" + matrizA[4][2] + "|" + matrizA[4][3] + "|" + matrizA[4][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB[4][0] + "|" + matrizB[4][1] + "|" + matrizB[4][2] + " |" + matrizB[4][3] + " |" + matrizB[4][4] + "|</p><br>");
                                                    t.print("<p align=center >Lo que se realizo fue sumar cada posición de cada matriz y ese resultado colocarlo en una matriz llamada resultado<br><br><br>");
                                                    t.print("int[][] resultado = new int[5][5];</p><br>");

                                                    t.print("<p align=center >Para optimizar el código se utilizó dos ciclos for recorriendo toda la matriz A y asi poder sumar todos los datos.<br><br><br>");
                                                    t.print("for (int i = 0; i < matrizA.length; i++) {<br>");
                                                    t.print("for (int j = 0; j < matrizA[i].length; j++) {<br>");
                                                    t.print(" resultado [i][j] = matrizA[i][j]+matrizB[i][j];}}</p><br>");
                                                    t.print("<p align=center > Y con esto obtenemos: </p><br>");

                                                    t.print("<p align=center >|" + resultado[0][0] + " |" + resultado[0][1] + " |" + resultado[0][2] + "  |" + resultado[0][3] + "  |" + resultado[0][4] + " |<br>");
                                                    t.print("|" + resultado[1][0] + " |" + resultado[1][1] + " |" + resultado[1][2] + "  |" + resultado[1][3] + " |" + resultado[1][4] + "|<br>");
                                                    t.print("|" + resultado[2][0] + " |" + resultado[2][1] + " |" + resultado[2][2] + " |" + resultado[2][3] + " |" + resultado[2][4] + "|<br>");
                                                    t.print("|" + resultado[3][0] + " |" + resultado[3][1] + " |" + resultado[3][2] + " |" + resultado[3][3] + " |" + resultado[3][4] + "|<br>");
                                                    t.print("|" + resultado[4][0] + " |" + resultado[4][1] + "|" + resultado[4][2] + " |" + resultado[4][3] + " |" + resultado[4][4] + "|<br>");
                                                    t.print("<p align=center>Tu cálculo fue: " + bitacora[5] + "</p><br>");
                                                    t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                    t.format("</p>");

                                                    break;

                                            }

                                            break;
                                        case 3:
                                            switch (bitacora[4]) {
                                                case 1:
                                                    t.print("<br><p align=center>Tu castigo fue una operación Dificil &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                    t.print("<p align=center >Tu operación corresponde a la división de las siguientes matrices: </p><br>");
                                                    t.print("<p align=center>|" + matrizA1[0][0] + " |" + matrizA1[0][1] + "|" + matrizA1[0][2] + " |" + matrizA1[0][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB1[0][0] + " |" + matrizB1[0][1] + "|" + matrizB1[0][2] + " |" + matrizB1[0][3] + " |<br>");
                                                    t.print("|" + matrizA1[1][0] + " |" + matrizA1[1][1] + "|" + matrizA1[1][2] + " |" + matrizA1[1][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB1[1][0] + " |" + matrizB1[1][1] + " |" + matrizB1[1][2] + " |" + matrizB1[1][3] + " |<br>");
                                                    t.print("|" + matrizA1[2][0] + " |" + matrizA1[2][1] + " |" + matrizA1[2][2] + "|" + matrizA1[2][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB1[2][0] + " |" + matrizB1[2][1] + "|" + matrizB1[2][2] + "|" + matrizB1[2][3] + "|<br>");
                                                    t.print("|" + matrizA1[3][0] + " |" + matrizA1[3][1] + " |" + matrizA1[3][2] + " |" + matrizA1[3][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB1[3][0] + "|" + matrizB1[3][1] + " |" + matrizB1[3][2] + " |" + matrizB1[3][3] + " |</p><br>");
                                                    t.print("<p align=center >Al ser la dificultad máxima, los calculos deben ser precisos por ello el primer paso fue calcular la matriz inversa de B<br>");
                                                    t.print("El calculo de la matriz inversa se realizo por medio de agregarle 4 columnas mas conocida con el método de gauss jordan.<br>");
                                                    t.print("Con esto puesto aplicaremos igualmente gauss jordan a toda la matriz para que lo que esta en izquiera quede en derecha y<br>");
                                                    t.print("las columnas agregadas queden en lado derecho.</p><br>");
                                                    t.print("<p align=center >Para lograr esto debemos seguir el siguiente algoritmo: </p><br>");
                                                    t.print("<p align=center >Debemos verificar si [0][0] no es igual a cero, si es así intercambiar la fila por la siguiente hasta que no exista un 0 al inicio<br>");
                                                    t.print("Esto se logra por medio de un arreglo de una dimensión, guardando la fila 1 en ella, luego igualando la fila siguiente a fila 1 y por ultimo esa fila siguiente al arreglo auxiliar<br><br>");
                                                    t.print("matrizB0[0][j] = auxiliarb[j];<br>");
                                                    t.print("matrizB0[0][j] = matrizB0[3][j];<br>");
                                                    t.print("matrizB0[3][j] = auxiliarb[j];</p><br>");
                                                    t.print("<p align=center >NOTA IMPORTANTE: Cada paso acontinuación descrito va dentrod de un ciclo for inverso, esto con el fin de no alterar los calculos en su ejecución, del 7 hasta el 0</p><br>");
                                                    t.print("<p align=center >Debemos dividir toda la fila 1 dentro de [0][0]</p><br>");
                                                    t.print("<p align=center >Debemos restar toda la fila 2 con la multiplicación de [1][0] por fila 1 y esto se repite con fila 3 pero con [2][0] y 4 con [3][0]</p><br>");
                                                    t.print("<p align=center >Debemos dividir toda la fila 2 dentro de [1][1]</p><br>");
                                                    t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][1] por fila 2 y esto se repite con fila 3 pero con [2][1] y 4 con [3][1]</p><br>");
                                                    t.print("<p align=center >Debemos dividir toda la fila 3 dentro de [2][2]</p><br>");
                                                    t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][2] por fila 3 y esto se repite con fila 2 pero con [1][2] y 4 con [2][2]</p><br>");
                                                    t.print("<p align=center >Debemos dividir toda la fila 4 dentro de [3][3]</p><br>");
                                                    t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][3] por fila 4 y esto se repite con fila 2 pero con [1][3] y 3 con [2][3]</p><br>");
                                                    t.print("<p align=center >Con esto culminamos el proceso de la matriz inversa, con un cilco for doble pasamos todos los resultadoa  partir de columna 3 a una matriz auxiliar<br>");
                                                    t.print("for (int i = 0; i < 4; i++) {<br>");
                                                    t.print(" for (int j = 0; j < 4; j++) { <br>");
                                                    t.print("matrizbtotal1[i][j] = matrizB0[i][j + 4];}}</p><br>");
                                                    t.print("<p align=center >Por ultimo Multiplicamos nuestra matriz auxiliar por la matriz A para obtener oficilamente nuestro resultado,<br>");
                                                    t.print("Sin embargo no es un proceso sencillo, debemos usar un Triple for junto con un arreglo auxiliar para poder realizar esta multiplicación, pero sin duda es un proceso hermoso de apreciar en código</p><br>");
                                                    t.print("<p align=center >Una vez realizada la multiplicación obtenemos el siguiente resultado: </p><br>");
                                                    t.format("<br><p align=center >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][0]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][1]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][2]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][3]);
                                                    t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][0]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][1]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][2]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][3]);
                                                    t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][0]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][1]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][2]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][3]);
                                                    t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][0]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][1]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][2]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][3]);
                                                    t.print("</p>");
                                                    t.print("<p align=center>Tu cálculo fue: " + bitacora[5] + "</p><br>");
                                                    t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                    break;
                                                case 2:
                                                    t.print("<br><p align=center>Tu castigo fue una operación Dificil &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                    t.print("<p align=center >Tu operación corresponde a la división de las siguientes matrices: </p><br>");
                                                    t.print("<p align=center>|" + matrizA1[0][0] + " |" + matrizA1[0][1] + "|" + matrizA1[0][2] + " |" + matrizA1[0][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB1[0][0] + " |" + matrizB1[0][1] + "|" + matrizB1[0][2] + " |" + matrizB1[0][3] + " |<br>");
                                                    t.print("|" + matrizA1[1][0] + " |" + matrizA1[1][1] + "|" + matrizA1[1][2] + " |" + matrizA1[1][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB1[1][0] + " |" + matrizB1[1][1] + " |" + matrizB1[1][2] + " |" + matrizB1[1][3] + " |<br>");
                                                    t.print("|" + matrizA1[2][0] + " |" + matrizA1[2][1] + " |" + matrizA1[2][2] + "|" + matrizA1[2][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB1[2][0] + " |" + matrizB1[2][1] + "|" + matrizB1[2][2] + "|" + matrizB1[2][3] + "|<br>");
                                                    t.print("|" + matrizA1[3][0] + " |" + matrizA1[3][1] + " |" + matrizA1[3][2] + " |" + matrizA1[3][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB1[3][0] + "|" + matrizB1[3][1] + " |" + matrizB1[3][2] + " |" + matrizB1[3][3] + " |</p><br>");
                                                    t.print("<p align=center >Al ser la dificultad máxima, los calculos deben ser precisos por ello el primer paso fue calcular la matriz inversa de B<br>");
                                                    t.print("El calculo de la matriz inversa se realizo por medio de agregarle 4 columnas mas conocida con el método de gauss jordan.<br>");
                                                    t.print("Con esto puesto aplicaremos igualmente gauss jordan a toda la matriz para que lo que esta en izquiera quede en derecha y<br>");
                                                    t.print("las columnas agregadas queden en lado derecho.</p><br>");
                                                    t.print("<p align=center >Para lograr esto debemos seguir el siguiente algoritmo: </p><br>");
                                                    t.print("<p align=center >Debemos verificar si [0][0] no es igual a cero, si es así intercambiar la fila por la siguiente hasta que no exista un 0 al inicio<br>");
                                                    t.print("Esto se logra por medio de un arreglo de una dimensión, guardando la fila 1 en ella, luego igualando la fila siguiente a fila 1 y por ultimo esa fila siguiente al arreglo auxiliar<br><br>");
                                                    t.print("matrizB0[0][j] = auxiliarb[j];<br>");
                                                    t.print("matrizB0[0][j] = matrizB0[3][j];<br>");
                                                    t.print("matrizB0[3][j] = auxiliarb[j];</p><br>");
                                                    t.print("<p align=center >NOTA IMPORTANTE: Cada paso acontinuación descrito va dentrod de un ciclo for inverso, esto con el fin de no alterar los calculos en su ejecución, del 7 hasta el 0</p><br>");
                                                    t.print("<p align=center >Debemos dividir toda la fila 1 dentro de [0][0]</p><br>");
                                                    t.print("<p align=center >Debemos restar toda la fila 2 con la multiplicación de [1][0] por fila 1 y esto se repite con fila 3 pero con [2][0] y 4 con [3][0]</p><br>");
                                                    t.print("<p align=center >Debemos dividir toda la fila 2 dentro de [1][1]</p><br>");
                                                    t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][1] por fila 2 y esto se repite con fila 3 pero con [2][1] y 4 con [3][1]</p><br>");
                                                    t.print("<p align=center >Debemos dividir toda la fila 3 dentro de [2][2]</p><br>");
                                                    t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][2] por fila 3 y esto se repite con fila 2 pero con [1][2] y 4 con [2][2]</p><br>");
                                                    t.print("<p align=center >Debemos dividir toda la fila 4 dentro de [3][3]</p><br>");
                                                    t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][3] por fila 4 y esto se repite con fila 2 pero con [1][3] y 3 con [2][3]</p><br>");
                                                    t.print("<p align=center >Con esto culminamos el proceso de la matriz inversa, con un cilco for doble pasamos todos los resultadoa  partir de columna 3 a una matriz auxiliar<br>");
                                                    t.print("for (int i = 0; i < 4; i++) {<br>");
                                                    t.print(" for (int j = 0; j < 4; j++) { <br>");
                                                    t.print("matrizbtotal1[i][j] = matrizB0[i][j + 4];}}</p><br>");
                                                    t.print("<p align=center >Por ultimo Multiplicamos nuestra matriz auxiliar por la matriz A para obtener oficilamente nuestro resultado,<br>");
                                                    t.print("Sin embargo no es un proceso sencillo, debemos usar un Triple for junto con un arreglo auxiliar para poder realizar esta multiplicación, pero sin duda es un proceso hermoso de apreciar en código</p><br>");
                                                    t.print("<p align=center >Una vez realizada la multiplicación obtenemos el siguiente resultado: </p><br>");
                                                    t.format("<br><p align=center >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][0]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][1]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][2]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][3]);
                                                    t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][0]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][1]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][2]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][3]);
                                                    t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][0]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][1]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][2]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][3]);
                                                    t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][0]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][1]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][2]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][3]);
                                                    t.print("</p>");
                                                    t.print("<p align=center>Tu cálculo fue: " + bitacora[5] + "</p><br>");
                                                    t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                    break;
                                                case 3:
                                                    t.print("<br><p align=center>Tu castigo fue una operación Dificil &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                    t.print("<p align=center >Tu operación corresponde a la división de las siguientes matrices: </p><br>");
                                                    t.print("<p align=center>|" + matrizA1[0][0] + " |" + matrizA1[0][1] + "|" + matrizA1[0][2] + " |" + matrizA1[0][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB1[0][0] + " |" + matrizB1[0][1] + "|" + matrizB1[0][2] + " |" + matrizB1[0][3] + " |<br>");
                                                    t.print("|" + matrizA1[1][0] + " |" + matrizA1[1][1] + "|" + matrizA1[1][2] + " |" + matrizA1[1][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB1[1][0] + " |" + matrizB1[1][1] + " |" + matrizB1[1][2] + " |" + matrizB1[1][3] + " |<br>");
                                                    t.print("|" + matrizA1[2][0] + " |" + matrizA1[2][1] + " |" + matrizA1[2][2] + "|" + matrizA1[2][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB1[2][0] + " |" + matrizB1[2][1] + "|" + matrizB1[2][2] + "|" + matrizB1[2][3] + "|<br>");
                                                    t.print("|" + matrizA1[3][0] + " |" + matrizA1[3][1] + " |" + matrizA1[3][2] + " |" + matrizA1[3][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                    t.print("|" + matrizB1[3][0] + "|" + matrizB1[3][1] + " |" + matrizB1[3][2] + " |" + matrizB1[3][3] + " |</p><br>");
                                                    t.print("<p align=center >Al ser la dificultad máxima, los calculos deben ser precisos por ello el primer paso fue calcular la matriz inversa de B<br>");
                                                    t.print("El calculo de la matriz inversa se realizo por medio de agregarle 4 columnas mas conocida con el método de gauss jordan.<br>");
                                                    t.print("Con esto puesto aplicaremos igualmente gauss jordan a toda la matriz para que lo que esta en izquiera quede en derecha y<br>");
                                                    t.print("las columnas agregadas queden en lado derecho.</p><br>");
                                                    t.print("<p align=center >Para lograr esto debemos seguir el siguiente algoritmo: </p><br>");
                                                    t.print("<p align=center >Debemos verificar si [0][0] no es igual a cero, si es así intercambiar la fila por la siguiente hasta que no exista un 0 al inicio<br>");
                                                    t.print("Esto se logra por medio de un arreglo de una dimensión, guardando la fila 1 en ella, luego igualando la fila siguiente a fila 1 y por ultimo esa fila siguiente al arreglo auxiliar<br><br>");
                                                    t.print("matrizB0[0][j] = auxiliarb[j];<br>");
                                                    t.print("matrizB0[0][j] = matrizB0[3][j];<br>");
                                                    t.print("matrizB0[3][j] = auxiliarb[j];</p><br>");
                                                    t.print("<p align=center >NOTA IMPORTANTE: Cada paso acontinuación descrito va dentrod de un ciclo for inverso, esto con el fin de no alterar los calculos en su ejecución, del 7 hasta el 0</p><br>");
                                                    t.print("<p align=center >Debemos dividir toda la fila 1 dentro de [0][0]</p><br>");
                                                    t.print("<p align=center >Debemos restar toda la fila 2 con la multiplicación de [1][0] por fila 1 y esto se repite con fila 3 pero con [2][0] y 4 con [3][0]</p><br>");
                                                    t.print("<p align=center >Debemos dividir toda la fila 2 dentro de [1][1]</p><br>");
                                                    t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][1] por fila 2 y esto se repite con fila 3 pero con [2][1] y 4 con [3][1]</p><br>");
                                                    t.print("<p align=center >Debemos dividir toda la fila 3 dentro de [2][2]</p><br>");
                                                    t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][2] por fila 3 y esto se repite con fila 2 pero con [1][2] y 4 con [2][2]</p><br>");
                                                    t.print("<p align=center >Debemos dividir toda la fila 4 dentro de [3][3]</p><br>");
                                                    t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][3] por fila 4 y esto se repite con fila 2 pero con [1][3] y 3 con [2][3]</p><br>");
                                                    t.print("<p align=center >Con esto culminamos el proceso de la matriz inversa, con un cilco for doble pasamos todos los resultadoa  partir de columna 3 a una matriz auxiliar<br>");
                                                    t.print("for (int i = 0; i < 4; i++) {<br>");
                                                    t.print(" for (int j = 0; j < 4; j++) { <br>");
                                                    t.print("matrizbtotal1[i][j] = matrizB0[i][j + 4];}}</p><br>");
                                                    t.print("<p align=center >Por ultimo Multiplicamos nuestra matriz auxiliar por la matriz A para obtener oficilamente nuestro resultado,<br>");
                                                    t.print("Sin embargo no es un proceso sencillo, debemos usar un Triple for junto con un arreglo auxiliar para poder realizar esta multiplicación, pero sin duda es un proceso hermoso de apreciar en código</p><br>");
                                                    t.print("<p align=center >Una vez realizada la multiplicación obtenemos el siguiente resultado: </p><br>");
                                                    t.format("<br><p align=center >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][0]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][1]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][2]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][3]);
                                                    t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][0]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][1]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][2]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][3]);
                                                    t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][0]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][1]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][2]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][3]);
                                                    t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][0]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][1]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][2]);
                                                    t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][3]);
                                                    t.print("</p>");
                                                    t.print("<p align=center>Tu cálculo fue: " + bitacora[5] + "</p><br>");
                                                    t.print("<br><p align=center >=====================================================================================================================================</p>");

                                                    break;

                                            }

                                            break;

                                    }

                                } else {
                                    //nada

                                }

                                posicionsuma = posicion;

                                break;

                            case "p":
                                System.out.println(menu);
                                System.out.println(op1);
                                System.out.println(op2);
                                System.out.println(op3);
                                System.out.println(op4);
                                opciontotal = opcion.nextInt();

                                switch (opciontotal) {
                                    case 1:
                                        System.out.println("¿Estas seguro que deseas iniciar un juego nuevo ? Se borrara todo registro de tu juego anterior");
                                        System.out.println("Coloca 1 para aceptar y 2 para cancelar");
                                        finopcion = fin.nextInt();
                                        if (finopcion == 1) {
                                            posicionsuma = 65;
                                            break;
                                        } else {

                                            System.out.println("Tu dado fue lanzado... a caído: " + dadosrandom);
                                            bitacora[0] = dadosrandom;
                                            posicion = posicion + dadosrandom;
                                            impresionposicion = posicion + 1;
                                            bitacora[1] = impresionposicion;

                                            //Impresión de la bitacora
                                            if (bitacora[2] == 0) {
                                                p.print("<br><p align=center>Tus dados en este turno fueron: " + bitacora[0] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                p.print("Tu nueva posición es la casilla: " + bitacora[1] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                p.print("No caíste en penalización</p>");

                                            } else {
                                                switch (bitacora[3]) {
                                                    case 1:
                                                        p.print("<br><p align=center>Tus dados en este turno fueron: " + bitacora[0] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                        p.print("Tu nueva posición es la casilla: " + bitacora[1] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                        p.print("¡Caíste en una penalización!</p>");
                                                        p.print("<br><p align=center>Tu castigo fue una operación fácil&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                        p.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                        t.print("<p align=center>Tu cálculo fue: " + bitacora[5] + "</p><br>");
                                                        break;
                                                    case 2:
                                                        p.print("<br><p align=center>Tus dados en este turno fueron: " + bitacora[0] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                        p.print("Tu nueva posición es la casilla: " + bitacora[1] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                        p.print("¡Caíste en una penalización!</p>");
                                                        p.print("<br><p align=center>Tu castigo fue una operación intermedia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                        p.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                        t.print("<p align=center>Tu cálculo fue: " + bitacora[5] + "</p><br>");
                                                        break;
                                                    case 3:
                                                        p.print("<br><p align=center>Tus dados en este turno fueron: " + bitacora[0] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                        p.print("Tu nueva posición es la casilla: " + bitacora[1] + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                        p.print("¡Caíste en una penalización!</p>");
                                                        p.print("<br><p align=center>Tu castigo fue una operación dificil&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                        p.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                        t.print("<p align=center>Tu cálculo fue: " + bitacora[5] + "</p><br>");
                                                        break;

                                                }

                                            }

                                            //Impresión de reporte
                                            if (bitacora[2] == 1) {
                                                switch (bitacora[3]) {
                                                    case 1:
                                                        switch (bitacora[4]) {
                                                            case 1:
                                                                t.print("<br><p align=center>Tu castigo fue una operación fácil&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                                t.print("<p align=center>Se nos proporciona el lado A con valor: " + ladoA + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Se nos proporciona el lado C con valor: " + ladoC + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("y un angulo B de valor: " + anguloB + "</p>");
                                                                t.print("<br><p align=center>Necesitamos encontrar el lado y los ángulos restantes</p>");
                                                                t.print("<br><p align=center>Convertimos el Angulo " + anguloB + " a radianes ya que Math.cos trabaja con ángulos en radianes.</p><br>");
                                                                t.print("<p align=center>Utilizando Math.toRadians transformamos y nos da como resultado: " + anguloB_rad + "</p><br>");
                                                                t.print("<p align=center>Para calcular el lado faltante utilizamos ley de coseno, sacaremos la raíz cuadrada de   A^2 + C^2 -2*A*C*cos" + anguloB + "</p><br>");
                                                                t.print("<p align=center>Utilizando Math.sqrt(((ladoA) * (ladoA)) + ((ladoC) * (ladoC)) - (2 * ladoA * ladoC * (Math.cos(anguloB_rad)))) obtenemos: " + ladoB + "</p><br>");
                                                                t.print("<p align=center>Para calcular el primer angulo faltante utilizamos ley de coseno nuevamente, calculando el arccoseno de   (-A^2 - C^2 + B^2)/-2*A*C</p><br>");
                                                                t.print("<p align=center>Utilizando Math.acos(((-(ladoC) * (ladoC)) + ((ladoA) * (ladoA)) - ((ladoB) * (ladoB))) / (-2 * ladoA * ladoB)) obtenemos: " + anguloA + "</p><br>");
                                                                t.print("<p align=center>Convertimos el Angulo " + anguloA + " a grados ya que los demas estan en grados.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Utilizando Math.toDegrees obtenemos: " + anguloA_grados + "</p>");
                                                                t.print("<br><p align=center>Para el angulo faltante, realizamos 180 - " + anguloB + " - " + anguloA_grados + " y esto nos da: " + anguloC + "</p>");
                                                                t.print("<br><p align=center >Los resultados totales son:</p>");
                                                                t.format("<br><p align=center >Lado A= " + "%.3f" + "\n", ladoA);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lado B= " + "%.3f" + "\n", ladoB);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lado C= " + "%.3f" + "\n", ladoC);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo A= " + "%.3f" + "\n", anguloA_grados);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo B= " + "%.3f" + "\n", anguloB);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo C= " + "%.3f" + "\n", anguloC);
                                                                t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                                break;
                                                            case 2:
                                                                t.print("<br><p align=center>Tu castigo fue una operación fácil&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                                t.print("<p align=center>Se nos proporciona el lado C con valor: " + ladoC + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Se nos proporciona el lado B con valor: " + ladoB + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("y un angulo A de valor: " + anguloA + "</p>");
                                                                t.print("<br><p align=center>Necesitamos encontrar el lado y los ángulos restantes</p>");
                                                                t.print("<br><p align=center>Convertimos el Angulo " + anguloA + " a radianes ya que Math.cos trabaja con ángulos en radianes.</p><br>");
                                                                t.print("<p align=center>Utilizando Math.toRadians transformamos y nos da como resultado: " + anguloA_rad + "</p><br>");
                                                                t.print("<p align=center>Para calcular el lado faltante utilizamos ley de coseno, sacaremos la raíz cuadrada de   B^2 + C^2 -2*B*C*cos" + anguloA_rad + "</p><br>");
                                                                t.print("<p align=center>Utilizando Math.sqrt(((ladoB) * (ladoB)) + ((ladoC) * (ladoC)) - (2 * ladoB * ladoC * (Math.cos(anguloA_rad)))) obtenemos: " + ladoA + "</p><br>");
                                                                t.print("<p align=center>Para calcular el primer angulo faltante utilizamos ley de coseno nuevamente, calculando el arccoseno de   (A^2 - C^2 - B^2)/-2*B*C</p><br>");
                                                                t.print("<p align=center>Utilizando Math.acos((-((ladoC) * (ladoC)) - ((ladoA) * (ladoA)) + ((ladoB) * (ladoB))) / (-2 * ladoA * ladoC)) obtenemos: " + anguloB + "</p><br>");
                                                                t.print("<p align=center>Convertimos el Angulo " + anguloB + " a grados ya que los demas estan en grados.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Utilizando Math.toDegrees obtenemos: " + anguloB_grados + "</p>");
                                                                t.print("<br><p align=center>Para el angulo faltante, realizamos 180 - " + anguloA + " - " + anguloB_grados + " y esto nos da: " + anguloC + "</p>");
                                                                t.print("<br><p align=center >Los resultados totales son:</p>");
                                                                t.format("<br><p align=center >Lado A= " + "%.3f" + "\n", ladoA);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lado B= " + "%.3f" + "\n", ladoB);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lado C= " + "%.3f" + "\n", ladoC);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo A= " + "%.3f" + "\n", anguloA);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo B= " + "%.3f" + "\n", anguloB_grados);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo C= " + "%.3f" + "\n", anguloC);
                                                                t.print("<br><p align=center >=====================================================================================================================================</p>");

                                                                break;
                                                            case 3:
                                                                t.print("<br><p align=center>Tu castigo fue una operación fácil&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                                t.print("<p align=center>Se nos proporciona el lado A con valor: " + ladoA + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Se nos proporciona el lado B con valor: " + ladoB + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("y un angulo C de valor: " + anguloC + "</p>");
                                                                t.print("<br><p align=center>Necesitamos encontrar el lado y los ángulos restantes</p>");
                                                                t.print("<br><p align=center>Convertimos el Angulo " + anguloC + " a radianes ya que Math.cos trabaja con ángulos en radianes.</p><br>");
                                                                t.print("<p align=center>Utilizando Math.toRadians transformamos y nos da como resultado: " + anguloC_rad + "</p><br>");
                                                                t.print("<p align=center>Para calcular el lado faltante utilizamos ley de coseno, sacaremos la raíz cuadrada de   B^2 + A^2 -2*A*B*cos" + anguloC_rad + "</p><br>");
                                                                t.print("<p align=center>Utilizando  Math.sqrt(((ladoB) * (ladoB)) + ((ladoA) * (ladoA)) - (2 * ladoB * ladoA * (Math.cos(anguloC_rad)))) obtenemos: " + ladoC + "</p><br>");
                                                                t.print("<p align=center>Para calcular el primer angulo faltante utilizamos ley de coseno nuevamente, calculando el arccoseno de   (-A^2 + C^2 - B^2)/-2*A*B</p><br>");
                                                                t.print("<p align=center>Utilizando Math.acos((-((ladoC) * (ladoC)) + ((ladoA) * (ladoA)) - ((ladoB) * (ladoB))) / (-2 * ladoB * ladoC)) obtenemos: " + anguloA + "</p><br>");
                                                                t.print("<p align=center>Convertimos el Angulo " + anguloA + " a grados ya que los demas estan en grados.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Utilizando Math.toDegrees obtenemos: " + anguloA_grados + "</p>");
                                                                t.print("<br><p align=center>Para el angulo faltante, realizamos 180 - " + anguloC + " - " + anguloA_grados + " y esto nos da: " + anguloB + "</p>");
                                                                t.print("<br><p align=center >Los resultados totales son:</p>");
                                                                t.format("<br><p align=center >Lado A= " + "%.3f" + "\n", ladoA);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lado B= " + "%.3f" + "\n", ladoB);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lado C= " + "%.3f" + "\n", ladoC);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo A= " + "%.3f" + "\n", anguloA_grados);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo B= " + "%.3f" + "\n", anguloB);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Angulo C= " + "%.3f" + "\n", anguloC);
                                                                t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                                break;

                                                        }

                                                        break;
                                                    case 2:
                                                        switch (bitacora[4]) {
                                                            case 1:
                                                                t.print("<br><p align=center>Tu castigo fue una operación intermedia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                                t.print("<p align=center >Tu operación corresponde a la suma de las siguientes matrices: </p><br>");
                                                                t.print("<p align=center>|" + matrizA[0][0] + " |" + matrizA[0][1] + "|" + matrizA[0][2] + " |" + matrizA[0][3] + " |" + matrizA[0][4] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[0][0] + " |" + matrizB[0][1] + " |" + matrizB[0][2] + " |" + matrizB[0][3] + " |" + matrizB[0][4] + "|<br>");
                                                                t.print("|" + matrizA[1][0] + "|" + matrizA[1][1] + " |" + matrizA[1][2] + " |" + matrizA[1][3] + " |" + matrizA[1][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[1][0] + " |" + matrizB[1][1] + " |" + matrizB[1][2] + " |" + matrizB[1][3] + "|" + matrizB[1][4] + "|<br>");
                                                                t.print("|" + matrizA[2][0] + " |" + matrizA[2][1] + " |" + matrizA[2][2] + " |" + matrizA[2][3] + "|" + matrizA[2][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[2][0] + "|" + matrizB[2][1] + "|" + matrizB[2][2] + "|" + matrizB[2][3] + "|" + matrizB[2][4] + "|<br>");
                                                                t.print("|" + matrizA[3][0] + "|" + matrizA[3][1] + "|" + matrizA[3][2] + " |" + matrizA[3][3] + "|" + matrizA[3][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[3][0] + " |" + matrizB[3][1] + "|" + matrizB[3][2] + "|" + matrizB[3][3] + "|" + matrizB[3][4] + "|<br>");
                                                                t.print("|" + matrizA[4][0] + "|" + matrizA[4][1] + "|" + matrizA[4][2] + "|" + matrizA[4][3] + "|" + matrizA[4][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[4][0] + "|" + matrizB[4][1] + "|" + matrizB[4][2] + " |" + matrizB[4][3] + " |" + matrizB[4][4] + "|</p><br>");
                                                                t.print("<p align=center >Lo que se realizo fue sumar cada posición de cada matriz y ese resultado colocarlo en una matriz llamada resultado<br><br><br>");
                                                                t.print("int[][] resultado = new int[5][5];</p><br>");

                                                                t.print("<p align=center >Para optimizar el código se utilizó dos ciclos for recorriendo toda la matriz A y asi poder sumar todos los datos.<br><br><br>");
                                                                t.print("for (int i = 0; i < matrizA.length; i++) {<br>");
                                                                t.print("for (int j = 0; j < matrizA[i].length; j++) {<br>");
                                                                t.print(" resultado [i][j] = matrizA[i][j]+matrizB[i][j];}}</p><br>");
                                                                t.print("<p align=center > Y con esto obtenemos: </p><br>");

                                                                t.print("<p align=center >|" + resultado[0][0] + " |" + resultado[0][1] + " |" + resultado[0][2] + "  |" + resultado[0][3] + "  |" + resultado[0][4] + " |<br>");
                                                                t.print("|" + resultado[1][0] + " |" + resultado[1][1] + " |" + resultado[1][2] + "  |" + resultado[1][3] + " |" + resultado[1][4] + "|<br>");
                                                                t.print("|" + resultado[2][0] + " |" + resultado[2][1] + " |" + resultado[2][2] + " |" + resultado[2][3] + " |" + resultado[2][4] + "|<br>");
                                                                t.print("|" + resultado[3][0] + " |" + resultado[3][1] + " |" + resultado[3][2] + " |" + resultado[3][3] + " |" + resultado[3][4] + "|<br>");
                                                                t.print("|" + resultado[4][0] + " |" + resultado[4][1] + "|" + resultado[4][2] + " |" + resultado[4][3] + " |" + resultado[4][4] + "|<br>");
                                                                t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                                t.format("</p>");
                                                                break;
                                                            case 2:
                                                                t.print("<br><p align=center>Tu castigo fue una operación intermedia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                                t.print("<p align=center >Tu operación corresponde a la suma de las siguientes matrices: </p><br>");
                                                                t.print("<p align=center>|" + matrizA[0][0] + " |" + matrizA[0][1] + "|" + matrizA[0][2] + " |" + matrizA[0][3] + " |" + matrizA[0][4] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[0][0] + " |" + matrizB[0][1] + " |" + matrizB[0][2] + " |" + matrizB[0][3] + " |" + matrizB[0][4] + "|<br>");
                                                                t.print("|" + matrizA[1][0] + "|" + matrizA[1][1] + " |" + matrizA[1][2] + " |" + matrizA[1][3] + " |" + matrizA[1][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[1][0] + " |" + matrizB[1][1] + " |" + matrizB[1][2] + " |" + matrizB[1][3] + "|" + matrizB[1][4] + "|<br>");
                                                                t.print("|" + matrizA[2][0] + " |" + matrizA[2][1] + " |" + matrizA[2][2] + " |" + matrizA[2][3] + "|" + matrizA[2][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[2][0] + "|" + matrizB[2][1] + "|" + matrizB[2][2] + "|" + matrizB[2][3] + "|" + matrizB[2][4] + "|<br>");
                                                                t.print("|" + matrizA[3][0] + "|" + matrizA[3][1] + "|" + matrizA[3][2] + " |" + matrizA[3][3] + "|" + matrizA[3][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[3][0] + " |" + matrizB[3][1] + "|" + matrizB[3][2] + "|" + matrizB[3][3] + "|" + matrizB[3][4] + "|<br>");
                                                                t.print("|" + matrizA[4][0] + "|" + matrizA[4][1] + "|" + matrizA[4][2] + "|" + matrizA[4][3] + "|" + matrizA[4][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[4][0] + "|" + matrizB[4][1] + "|" + matrizB[4][2] + " |" + matrizB[4][3] + " |" + matrizB[4][4] + "|</p><br>");
                                                                t.print("<p align=center >Lo que se realizo fue sumar cada posición de cada matriz y ese resultado colocarlo en una matriz llamada resultado<br><br><br>");
                                                                t.print("int[][] resultado = new int[5][5];</p><br>");

                                                                t.print("<p align=center >Para optimizar el código se utilizó dos ciclos for recorriendo toda la matriz A y asi poder sumar todos los datos.<br><br><br>");
                                                                t.print("for (int i = 0; i < matrizA.length; i++) {<br>");
                                                                t.print("for (int j = 0; j < matrizA[i].length; j++) {<br>");
                                                                t.print(" resultado [i][j] = matrizA[i][j]+matrizB[i][j];}}</p><br>");
                                                                t.print("<p align=center > Y con esto obtenemos: </p><br>");

                                                                t.print("<p align=center >|" + resultado[0][0] + " |" + resultado[0][1] + " |" + resultado[0][2] + "  |" + resultado[0][3] + "  |" + resultado[0][4] + " |<br>");
                                                                t.print("|" + resultado[1][0] + " |" + resultado[1][1] + " |" + resultado[1][2] + "  |" + resultado[1][3] + " |" + resultado[1][4] + "|<br>");
                                                                t.print("|" + resultado[2][0] + " |" + resultado[2][1] + " |" + resultado[2][2] + " |" + resultado[2][3] + " |" + resultado[2][4] + "|<br>");
                                                                t.print("|" + resultado[3][0] + " |" + resultado[3][1] + " |" + resultado[3][2] + " |" + resultado[3][3] + " |" + resultado[3][4] + "|<br>");
                                                                t.print("|" + resultado[4][0] + " |" + resultado[4][1] + "|" + resultado[4][2] + " |" + resultado[4][3] + " |" + resultado[4][4] + "|<br>");
                                                                t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                                t.format("</p>");

                                                                break;
                                                            case 3:
                                                                t.print("<br><p align=center>Tu castigo fue una operación intermedia&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                                t.print("<p align=center >Tu operación corresponde a la suma de las siguientes matrices: </p><br>");
                                                                t.print("<p align=center>|" + matrizA[0][0] + " |" + matrizA[0][1] + "|" + matrizA[0][2] + " |" + matrizA[0][3] + " |" + matrizA[0][4] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[0][0] + " |" + matrizB[0][1] + " |" + matrizB[0][2] + " |" + matrizB[0][3] + " |" + matrizB[0][4] + "|<br>");
                                                                t.print("|" + matrizA[1][0] + "|" + matrizA[1][1] + " |" + matrizA[1][2] + " |" + matrizA[1][3] + " |" + matrizA[1][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[1][0] + " |" + matrizB[1][1] + " |" + matrizB[1][2] + " |" + matrizB[1][3] + "|" + matrizB[1][4] + "|<br>");
                                                                t.print("|" + matrizA[2][0] + " |" + matrizA[2][1] + " |" + matrizA[2][2] + " |" + matrizA[2][3] + "|" + matrizA[2][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[2][0] + "|" + matrizB[2][1] + "|" + matrizB[2][2] + "|" + matrizB[2][3] + "|" + matrizB[2][4] + "|<br>");
                                                                t.print("|" + matrizA[3][0] + "|" + matrizA[3][1] + "|" + matrizA[3][2] + " |" + matrizA[3][3] + "|" + matrizA[3][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[3][0] + " |" + matrizB[3][1] + "|" + matrizB[3][2] + "|" + matrizB[3][3] + "|" + matrizB[3][4] + "|<br>");
                                                                t.print("|" + matrizA[4][0] + "|" + matrizA[4][1] + "|" + matrizA[4][2] + "|" + matrizA[4][3] + "|" + matrizA[4][4] + "|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB[4][0] + "|" + matrizB[4][1] + "|" + matrizB[4][2] + " |" + matrizB[4][3] + " |" + matrizB[4][4] + "|</p><br>");
                                                                t.print("<p align=center >Lo que se realizo fue sumar cada posición de cada matriz y ese resultado colocarlo en una matriz llamada resultado<br><br><br>");
                                                                t.print("int[][] resultado = new int[5][5];</p><br>");

                                                                t.print("<p align=center >Para optimizar el código se utilizó dos ciclos for recorriendo toda la matriz A y asi poder sumar todos los datos.<br><br><br>");
                                                                t.print("for (int i = 0; i < matrizA.length; i++) {<br>");
                                                                t.print("for (int j = 0; j < matrizA[i].length; j++) {<br>");
                                                                t.print(" resultado [i][j] = matrizA[i][j]+matrizB[i][j];}}</p><br>");
                                                                t.print("<p align=center > Y con esto obtenemos: </p><br>");

                                                                t.print("<p align=center >|" + resultado[0][0] + " |" + resultado[0][1] + " |" + resultado[0][2] + "  |" + resultado[0][3] + "  |" + resultado[0][4] + " |<br>");
                                                                t.print("|" + resultado[1][0] + " |" + resultado[1][1] + " |" + resultado[1][2] + "  |" + resultado[1][3] + " |" + resultado[1][4] + "|<br>");
                                                                t.print("|" + resultado[2][0] + " |" + resultado[2][1] + " |" + resultado[2][2] + " |" + resultado[2][3] + " |" + resultado[2][4] + "|<br>");
                                                                t.print("|" + resultado[3][0] + " |" + resultado[3][1] + " |" + resultado[3][2] + " |" + resultado[3][3] + " |" + resultado[3][4] + "|<br>");
                                                                t.print("|" + resultado[4][0] + " |" + resultado[4][1] + "|" + resultado[4][2] + " |" + resultado[4][3] + " |" + resultado[4][4] + "|<br>");
                                                                t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                                t.format("</p>");

                                                                break;

                                                        }

                                                        break;
                                                    case 3:
                                                        switch (bitacora[4]) {
                                                            case 1:
                                                                t.print("<br><p align=center>Tu castigo fue una operación Dificil &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                                t.print("<p align=center >Tu operación corresponde a la división de las siguientes matrices: </p><br>");
                                                                t.print("<p align=center>|" + matrizA1[0][0] + " |" + matrizA1[0][1] + "|" + matrizA1[0][2] + " |" + matrizA1[0][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB1[0][0] + " |" + matrizB1[0][1] + "|" + matrizB1[0][2] + " |" + matrizB1[0][3] + " |<br>");
                                                                t.print("|" + matrizA1[1][0] + " |" + matrizA1[1][1] + "|" + matrizA1[1][2] + " |" + matrizA1[1][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB1[1][0] + " |" + matrizB1[1][1] + " |" + matrizB1[1][2] + " |" + matrizB1[1][3] + " |<br>");
                                                                t.print("|" + matrizA1[2][0] + " |" + matrizA1[2][1] + " |" + matrizA1[2][2] + "|" + matrizA1[2][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB1[2][0] + " |" + matrizB1[2][1] + "|" + matrizB1[2][2] + "|" + matrizB1[2][3] + "|<br>");
                                                                t.print("|" + matrizA1[3][0] + " |" + matrizA1[3][1] + " |" + matrizA1[3][2] + " |" + matrizA1[3][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB1[3][0] + "|" + matrizB1[3][1] + " |" + matrizB1[3][2] + " |" + matrizB1[3][3] + " |</p><br>");
                                                                t.print("<p align=center >Al ser la dificultad máxima, los calculos deben ser precisos por ello el primer paso fue calcular la matriz inversa de B<br>");
                                                                t.print("El calculo de la matriz inversa se realizo por medio de agregarle 4 columnas mas conocida con el método de gauss jordan.<br>");
                                                                t.print("Con esto puesto aplicaremos igualmente gauss jordan a toda la matriz para que lo que esta en izquiera quede en derecha y<br>");
                                                                t.print("las columnas agregadas queden en lado derecho.</p><br>");
                                                                t.print("<p align=center >Para lograr esto debemos seguir el siguiente algoritmo: </p><br>");
                                                                t.print("<p align=center >Debemos verificar si [0][0] no es igual a cero, si es así intercambiar la fila por la siguiente hasta que no exista un 0 al inicio<br>");
                                                                t.print("Esto se logra por medio de un arreglo de una dimensión, guardando la fila 1 en ella, luego igualando la fila siguiente a fila 1 y por ultimo esa fila siguiente al arreglo auxiliar<br><br>");
                                                                t.print("matrizB0[0][j] = auxiliarb[j];<br>");
                                                                t.print("matrizB0[0][j] = matrizB0[3][j];<br>");
                                                                t.print("matrizB0[3][j] = auxiliarb[j];</p><br>");
                                                                t.print("<p align=center >NOTA IMPORTANTE: Cada paso acontinuación descrito va dentrod de un ciclo for inverso, esto con el fin de no alterar los calculos en su ejecución, del 7 hasta el 0</p><br>");
                                                                t.print("<p align=center >Debemos dividir toda la fila 1 dentro de [0][0]</p><br>");
                                                                t.print("<p align=center >Debemos restar toda la fila 2 con la multiplicación de [1][0] por fila 1 y esto se repite con fila 3 pero con [2][0] y 4 con [3][0]</p><br>");
                                                                t.print("<p align=center >Debemos dividir toda la fila 2 dentro de [1][1]</p><br>");
                                                                t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][1] por fila 2 y esto se repite con fila 3 pero con [2][1] y 4 con [3][1]</p><br>");
                                                                t.print("<p align=center >Debemos dividir toda la fila 3 dentro de [2][2]</p><br>");
                                                                t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][2] por fila 3 y esto se repite con fila 2 pero con [1][2] y 4 con [2][2]</p><br>");
                                                                t.print("<p align=center >Debemos dividir toda la fila 4 dentro de [3][3]</p><br>");
                                                                t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][3] por fila 4 y esto se repite con fila 2 pero con [1][3] y 3 con [2][3]</p><br>");
                                                                t.print("<p align=center >Con esto culminamos el proceso de la matriz inversa, con un cilco for doble pasamos todos los resultadoa  partir de columna 3 a una matriz auxiliar<br>");
                                                                t.print("for (int i = 0; i < 4; i++) {<br>");
                                                                t.print(" for (int j = 0; j < 4; j++) { <br>");
                                                                t.print("matrizbtotal1[i][j] = matrizB0[i][j + 4];}}</p><br>");
                                                                t.print("<p align=center >Por ultimo Multiplicamos nuestra matriz auxiliar por la matriz A para obtener oficilamente nuestro resultado,<br>");
                                                                t.print("Sin embargo no es un proceso sencillo, debemos usar un Triple for junto con un arreglo auxiliar para poder realizar esta multiplicación, pero sin duda es un proceso hermoso de apreciar en código</p><br>");
                                                                t.print("<p align=center >Una vez realizada la multiplicación obtenemos el siguiente resultado: </p><br>");
                                                                t.format("<br><p align=center >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][0]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][1]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][2]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][3]);
                                                                t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][0]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][1]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][2]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][3]);
                                                                t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][0]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][1]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][2]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][3]);
                                                                t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][0]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][1]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][2]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][3]);
                                                                t.print("</p>");
                                                                t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                                break;
                                                            case 2:
                                                                t.print("<br><p align=center>Tu castigo fue una operación Dificil &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                                t.print("<p align=center >Tu operación corresponde a la división de las siguientes matrices: </p><br>");
                                                                t.print("<p align=center>|" + matrizA1[0][0] + " |" + matrizA1[0][1] + "|" + matrizA1[0][2] + " |" + matrizA1[0][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB1[0][0] + " |" + matrizB1[0][1] + "|" + matrizB1[0][2] + " |" + matrizB1[0][3] + " |<br>");
                                                                t.print("|" + matrizA1[1][0] + " |" + matrizA1[1][1] + "|" + matrizA1[1][2] + " |" + matrizA1[1][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB1[1][0] + " |" + matrizB1[1][1] + " |" + matrizB1[1][2] + " |" + matrizB1[1][3] + " |<br>");
                                                                t.print("|" + matrizA1[2][0] + " |" + matrizA1[2][1] + " |" + matrizA1[2][2] + "|" + matrizA1[2][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB1[2][0] + " |" + matrizB1[2][1] + "|" + matrizB1[2][2] + "|" + matrizB1[2][3] + "|<br>");
                                                                t.print("|" + matrizA1[3][0] + " |" + matrizA1[3][1] + " |" + matrizA1[3][2] + " |" + matrizA1[3][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB1[3][0] + "|" + matrizB1[3][1] + " |" + matrizB1[3][2] + " |" + matrizB1[3][3] + " |</p><br>");
                                                                t.print("<p align=center >Al ser la dificultad máxima, los calculos deben ser precisos por ello el primer paso fue calcular la matriz inversa de B<br>");
                                                                t.print("El calculo de la matriz inversa se realizo por medio de agregarle 4 columnas mas conocida con el método de gauss jordan.<br>");
                                                                t.print("Con esto puesto aplicaremos igualmente gauss jordan a toda la matriz para que lo que esta en izquiera quede en derecha y<br>");
                                                                t.print("las columnas agregadas queden en lado derecho.</p><br>");
                                                                t.print("<p align=center >Para lograr esto debemos seguir el siguiente algoritmo: </p><br>");
                                                                t.print("<p align=center >Debemos verificar si [0][0] no es igual a cero, si es así intercambiar la fila por la siguiente hasta que no exista un 0 al inicio<br>");
                                                                t.print("Esto se logra por medio de un arreglo de una dimensión, guardando la fila 1 en ella, luego igualando la fila siguiente a fila 1 y por ultimo esa fila siguiente al arreglo auxiliar<br><br>");
                                                                t.print("matrizB0[0][j] = auxiliarb[j];<br>");
                                                                t.print("matrizB0[0][j] = matrizB0[3][j];<br>");
                                                                t.print("matrizB0[3][j] = auxiliarb[j];</p><br>");
                                                                t.print("<p align=center >NOTA IMPORTANTE: Cada paso acontinuación descrito va dentrod de un ciclo for inverso, esto con el fin de no alterar los calculos en su ejecución, del 7 hasta el 0</p><br>");
                                                                t.print("<p align=center >Debemos dividir toda la fila 1 dentro de [0][0]</p><br>");
                                                                t.print("<p align=center >Debemos restar toda la fila 2 con la multiplicación de [1][0] por fila 1 y esto se repite con fila 3 pero con [2][0] y 4 con [3][0]</p><br>");
                                                                t.print("<p align=center >Debemos dividir toda la fila 2 dentro de [1][1]</p><br>");
                                                                t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][1] por fila 2 y esto se repite con fila 3 pero con [2][1] y 4 con [3][1]</p><br>");
                                                                t.print("<p align=center >Debemos dividir toda la fila 3 dentro de [2][2]</p><br>");
                                                                t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][2] por fila 3 y esto se repite con fila 2 pero con [1][2] y 4 con [2][2]</p><br>");
                                                                t.print("<p align=center >Debemos dividir toda la fila 4 dentro de [3][3]</p><br>");
                                                                t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][3] por fila 4 y esto se repite con fila 2 pero con [1][3] y 3 con [2][3]</p><br>");
                                                                t.print("<p align=center >Con esto culminamos el proceso de la matriz inversa, con un cilco for doble pasamos todos los resultadoa  partir de columna 3 a una matriz auxiliar<br>");
                                                                t.print("for (int i = 0; i < 4; i++) {<br>");
                                                                t.print(" for (int j = 0; j < 4; j++) { <br>");
                                                                t.print("matrizbtotal1[i][j] = matrizB0[i][j + 4];}}</p><br>");
                                                                t.print("<p align=center >Por ultimo Multiplicamos nuestra matriz auxiliar por la matriz A para obtener oficilamente nuestro resultado,<br>");
                                                                t.print("Sin embargo no es un proceso sencillo, debemos usar un Triple for junto con un arreglo auxiliar para poder realizar esta multiplicación, pero sin duda es un proceso hermoso de apreciar en código</p><br>");
                                                                t.print("<p align=center >Una vez realizada la multiplicación obtenemos el siguiente resultado: </p><br>");
                                                                t.format("<br><p align=center >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][0]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][1]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][2]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][3]);
                                                                t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][0]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][1]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][2]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][3]);
                                                                t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][0]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][1]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][2]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][3]);
                                                                t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][0]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][1]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][2]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][3]);
                                                                t.print("</p>");
                                                                t.print("<br><p align=center >=====================================================================================================================================</p>");
                                                                break;
                                                            case 3:
                                                                t.print("<br><p align=center>Tu castigo fue una operación Dificil &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("Toco la opción: " + bitacora[4] + "</p><br>");
                                                                t.print("<p align=center >Tu operación corresponde a la división de las siguientes matrices: </p><br>");
                                                                t.print("<p align=center>|" + matrizA1[0][0] + " |" + matrizA1[0][1] + "|" + matrizA1[0][2] + " |" + matrizA1[0][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB1[0][0] + " |" + matrizB1[0][1] + "|" + matrizB1[0][2] + " |" + matrizB1[0][3] + " |<br>");
                                                                t.print("|" + matrizA1[1][0] + " |" + matrizA1[1][1] + "|" + matrizA1[1][2] + " |" + matrizA1[1][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB1[1][0] + " |" + matrizB1[1][1] + " |" + matrizB1[1][2] + " |" + matrizB1[1][3] + " |<br>");
                                                                t.print("|" + matrizA1[2][0] + " |" + matrizA1[2][1] + " |" + matrizA1[2][2] + "|" + matrizA1[2][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB1[2][0] + " |" + matrizB1[2][1] + "|" + matrizB1[2][2] + "|" + matrizB1[2][3] + "|<br>");
                                                                t.print("|" + matrizA1[3][0] + " |" + matrizA1[3][1] + " |" + matrizA1[3][2] + " |" + matrizA1[3][3] + " |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                                                t.print("|" + matrizB1[3][0] + "|" + matrizB1[3][1] + " |" + matrizB1[3][2] + " |" + matrizB1[3][3] + " |</p><br>");
                                                                t.print("<p align=center >Al ser la dificultad máxima, los calculos deben ser precisos por ello el primer paso fue calcular la matriz inversa de B<br>");
                                                                t.print("El calculo de la matriz inversa se realizo por medio de agregarle 4 columnas mas conocida con el método de gauss jordan.<br>");
                                                                t.print("Con esto puesto aplicaremos igualmente gauss jordan a toda la matriz para que lo que esta en izquiera quede en derecha y<br>");
                                                                t.print("las columnas agregadas queden en lado derecho.</p><br>");
                                                                t.print("<p align=center >Para lograr esto debemos seguir el siguiente algoritmo: </p><br>");
                                                                t.print("<p align=center >Debemos verificar si [0][0] no es igual a cero, si es así intercambiar la fila por la siguiente hasta que no exista un 0 al inicio<br>");
                                                                t.print("Esto se logra por medio de un arreglo de una dimensión, guardando la fila 1 en ella, luego igualando la fila siguiente a fila 1 y por ultimo esa fila siguiente al arreglo auxiliar<br><br>");
                                                                t.print("matrizB0[0][j] = auxiliarb[j];<br>");
                                                                t.print("matrizB0[0][j] = matrizB0[3][j];<br>");
                                                                t.print("matrizB0[3][j] = auxiliarb[j];</p><br>");
                                                                t.print("<p align=center >NOTA IMPORTANTE: Cada paso acontinuación descrito va dentrod de un ciclo for inverso, esto con el fin de no alterar los calculos en su ejecución, del 7 hasta el 0</p><br>");
                                                                t.print("<p align=center >Debemos dividir toda la fila 1 dentro de [0][0]</p><br>");
                                                                t.print("<p align=center >Debemos restar toda la fila 2 con la multiplicación de [1][0] por fila 1 y esto se repite con fila 3 pero con [2][0] y 4 con [3][0]</p><br>");
                                                                t.print("<p align=center >Debemos dividir toda la fila 2 dentro de [1][1]</p><br>");
                                                                t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][1] por fila 2 y esto se repite con fila 3 pero con [2][1] y 4 con [3][1]</p><br>");
                                                                t.print("<p align=center >Debemos dividir toda la fila 3 dentro de [2][2]</p><br>");
                                                                t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][2] por fila 3 y esto se repite con fila 2 pero con [1][2] y 4 con [2][2]</p><br>");
                                                                t.print("<p align=center >Debemos dividir toda la fila 4 dentro de [3][3]</p><br>");
                                                                t.print("<p align=center >Debemos restar toda la fila 1 con la multiplicación de [0][3] por fila 4 y esto se repite con fila 2 pero con [1][3] y 3 con [2][3]</p><br>");
                                                                t.print("<p align=center >Con esto culminamos el proceso de la matriz inversa, con un cilco for doble pasamos todos los resultadoa  partir de columna 3 a una matriz auxiliar<br>");
                                                                t.print("for (int i = 0; i < 4; i++) {<br>");
                                                                t.print(" for (int j = 0; j < 4; j++) { <br>");
                                                                t.print("matrizbtotal1[i][j] = matrizB0[i][j + 4];}}</p><br>");
                                                                t.print("<p align=center >Por ultimo Multiplicamos nuestra matriz auxiliar por la matriz A para obtener oficilamente nuestro resultado,<br>");
                                                                t.print("Sin embargo no es un proceso sencillo, debemos usar un Triple for junto con un arreglo auxiliar para poder realizar esta multiplicación, pero sin duda es un proceso hermoso de apreciar en código</p><br>");
                                                                t.print("<p align=center >Una vez realizada la multiplicación obtenemos el siguiente resultado: </p><br>");
                                                                t.format("<br><p align=center >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][0]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][1]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][2]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[0][3]);
                                                                t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][0]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][1]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][2]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[1][3]);
                                                                t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][0]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][1]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][2]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[2][3]);
                                                                t.format("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][0]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][1]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][2]);
                                                                t.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "%.3f" + "\n", resultadofinal1[3][3]);
                                                                t.print("</p>");
                                                                t.print("<br><p align=center >=====================================================================================================================================</p>");

                                                                break;

                                                        }

                                                        break;

                                                }

                                            } else {
                                                //nada

                                            }

                                            posicionsuma = posicion;
                                            break;
                                        }
                                    case 3:
                                        p.print("</body></html>");
                                        p.close();
                                        //Declaración de reporte
                                        t.print("</body></html>");
                                        t.close();

                                        posicionsuma = 70;
                                        break;

                                    case 4:
                                        System.out.println("Gracias por Jugar");
                                        System.exit(0);
                                        break;

                                }

                        }

                    }
                    t.print("</body></html>");
                    t.close();
                    p.print("<br><p align=center>¡Felicidades, ganaste!<br>");
                    p.print("</body></html>");
                    p.close();
                    System.out.println("Fin del juego");

                    break;
                case 2:

                    System.out.println("No tienes ningun juego iniciado");
                    break;
                case 3:

                    break;

                case 4:
                    System.out.println("Gracias por Jugar");
                    System.exit(0);
                    break;
            }

        }

    }
}

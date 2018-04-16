package metodo;

public class Hopfield {

    /**
     *  Calcula la matriz por su matriz transpuesta menos la matriz identidad
     *  Matriz * MatrizTranspuesta - Matriz Identidad
     */

    public static int[][] calcularMatrizEntrenamiento(int[][] matriz) {

        int[][] matrizT = calcularMatrizTranspuesta(matriz);
        int[][] matrizResultante = multiplicarMatrices(matriz, matrizT);

        int[][] matrizIdentidad = calcularMatrizIdentidad(matriz);

        imprimeMatriz(matrizIdentidad);

        return matrizResultante;
    }

    private static int[][] calcularMatrizTranspuesta(int[][] matriz) {
        int[][] matrizT = new int[matriz[0].length][matriz.length];

        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                matrizT[y][x] = matriz[x][y];
            }
        }

        return matrizT;
    }

    private static int[][] multiplicarMatrices(int[][] m1, int[][] m2) {

        int fil_m1 = m1.length;
        int col_m1 = m1[0].length;

        int fil_m2 = m2.length;
        int col_m2 = m2[0].length;

        /*  Solo puede multiplicar dos matrices si sus dimensiones son compatibles,
            lo que significa que el número de columnas en la primera matriz es igual
            al número de renglones en la segunda matriz.
            Si A es una matriz a × b y B es una matriz b × c , el producto AB es una matriz a × c.  */

        if (col_m1 != fil_m2)
            throw new RuntimeException("No se pueden multiplicar las matrices");

        int[][] multiplicacion = new int[fil_m1][col_m2];

        for (int x=0; x<multiplicacion.length; x++) {
            for (int y=0; y<multiplicacion[x].length; y++) {
                for (int z=0; z<col_m1; z++) {
                    multiplicacion [x][y] += m1[x][z] * m2[z][y];
                }
            }
        }

        return multiplicacion;
    }

    private static int[][] calcularMatrizIdentidad(int[][] matriz) {

        int filas = matriz.length;
        int columnas = matriz[0].length;

        int[][] matrizIdentidad = new int[filas][columnas];

        for (int x=0; x < filas; x++) {
            for (int y=0; y < columnas; y++) {
                if (x == y) {
                    matrizIdentidad[x][y] = 1;
                } else {
                    matrizIdentidad[x][y] = 0;
                }
            }
        }

        return matrizIdentidad;
    }

    public static void calcularDistanciaHamming(int[][] prueba1, int[][] prueba2){

        int n = prueba1.length*prueba2.length;
        System.out.println("N es: "+n);
        int distancia=0;
        for (int j=0;j<prueba1.length;j++){
            for (int k=0; k<prueba2.length;k++ ){
                distancia+=prueba1[j][k]*prueba2[j][k];
            }
        }
        System.out.println("Distancia de Hamming es: "+distancia);
    }

    private static void imprimeMatriz(int[][] matriz) {
        String strMatriz = "";
        for (int x=0; x<matriz.length; x++) {
            for (int y=0; y<matriz[x].length; y++) {
                strMatriz += matriz[x][y] + " ";
            }
            strMatriz += "\n";
        }

        System.out.println(strMatriz);
    }

}


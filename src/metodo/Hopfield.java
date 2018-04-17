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
        int[][] resultado = restarMatrices(matrizResultante, matrizIdentidad);
        System.out.println("---");
        imprimeMatriz(resultado);
        System.out.println("---");
        return resultado;
    }

    public static int[][] calcularMatrizTranspuesta(int[][] matriz) {
        int[][] matrizT = new int[matriz[0].length][matriz.length];

        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                matrizT[y][x] = matriz[x][y];
            }
        }
        //imprimeMatriz(matrizT);
        return matrizT;
    }

    public static int[][] multiplicarMatrices(int[][] m1, int[][] m2) {

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

    public static int[][] restarMatrices(int[][] m1, int[][] m2) {

        int filas = m1.length;
        int columnas = m1[0].length;

        int[][] resta = new int[filas][columnas];

        for (int x=0; x<filas; x++) {
            for (int y=0; y<columnas; y++) {
                resta[x][y] = m1[x][y] - m2[x][y];
            }
        }

        return resta;
    }

    public static int[][] sumarMatrices(int[][] m1, int[][] m2) {

        int filas = m1.length;
        int columnas = m1[0].length;

        int[][] suma = new int[filas][columnas];

        for (int x=0; x<filas; x++) {
            for (int y=0; y<columnas; y++) {
                suma[x][y] = m1[x][y] + m2[x][y];
            }
        }

        imprimeMatriz(suma);
        return suma;
    }

    private static int[][] calcularMatrizIdentidad(int[][] matriz) {

        int filas = matriz.length;
        int columnas = matriz[0].length;

        int[][] matrizIdentidad = new int[filas][columnas];

        for (int x=0; x<filas; x++) {
            for (int y=0; y<columnas; y++) {
                if (x == y) {
                    matrizIdentidad[x][y] = 1;
                } else {
                    matrizIdentidad[x][y] = 0;
                }
            }
        }

        return matrizIdentidad;
    }

    public static int calcularDistanciaHamming(int[][] prueba1, int[][] prueba2){

        int n = prueba1.length * prueba2.length;
        System.out.println("N es: " + n);

        int distancia = 0;
        for (int j=0;j<prueba1.length;j++){
            for (int k=0; k<prueba2.length;k++ ){
                distancia += prueba1[j][k] * prueba2[j][k];
            }
        }

        System.out.println("Distancia de Hamming es: "+distancia);
        return distancia;
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

    public static void CalcularRecuperacion(int[][] prueba1,int[][] prueba2){

        int m=2;
        int n=prueba1.length*prueba2.length;

        if(m<=0.138*n){
            System.out.println("La recuperacion es Buena de:"+0.138*n);
        }

        if(m<=(n/(4*Math.log(n)))){
                System.out.println("La recuperacion es Percpecta de:"+(n/(4*Math.log(n))));
        }

    }
}


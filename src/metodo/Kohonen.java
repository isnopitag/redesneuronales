package metodo;

import java.util.Arrays;

public class Kohonen {

    public static void calcularDistanciaEcladiana(int[][] matrizEntrada, double[][] matrizPesos, double alfa) {

        int nFilasEntradas = matrizEntrada.length;
        int nFilasPesos = matrizPesos.length;

        for (int i = 0; i < nFilasEntradas; i++) {

            int[] entradas = matrizEntrada[i];
            // System.out.println(Arrays.toString(entradas));

            double[] D = new double[nFilasPesos];

            for (int j = 0; j < nFilasPesos; j++) {
                double[] pesos = matrizPesos[j];
                // System.out.println(Arrays.toString(pesos));

                for (int k = 0; k < pesos.length; k++) {
                    D[j] += Math.pow(entradas[k] - pesos[k], 2);
                }
            }

            System.out.println("");
            System.out.println("Distancias : " + Arrays.toString(D));

            int J = indiceMenor(D);
            matrizPesos[J] = actualizarPesos(alfa, matrizPesos[J], entradas);

            try {

                System.out.println(Arrays.toString(matrizPesos[J - 1]));
                System.out.println(Arrays.toString(matrizPesos[J]));

            } catch (Exception ex) {

                System.out.println(Arrays.toString(matrizPesos[J]));
                System.out.println(Arrays.toString(matrizPesos[J + 1]));
            }

            System.out.println("");
        }
    }

    public static double[] actualizarPesos(double alfa, double[] columnaPesos, int[] entradas) {
        double[] nuevosPesos = new double[columnaPesos.length];

        for (int i=0; i<entradas.length; i++) {
            nuevosPesos[i] = columnaPesos[i] + alfa * (entradas[i] - columnaPesos[i]);
        }

        return nuevosPesos;
    }

    /*public static void calcularDistanciaEcladiana(int[][] matrizEntrada, double[][] matrizPesos, double alfa){

        for (int i = 0; i < matrizEntrada.length; i++) {

            double D[] = new double[matrizPesos.length];

            for (int j = 0; j < matrizPesos[0].length ; j++) {
                for (int k = 0; k < matrizPesos.length ; k++) {
                    D[k] += Math.pow((matrizEntrada[i][j] - matrizPesos[k][j]), 2);

                    System.out.println(D[k]);
                }
            }

            break;

            matrizPesos = calcularNuevaMatrizDePesos(matrizEntrada, matrizPesos, indiceMenor(d), i, alfa);
        }

        // Solo para debugear que este vien la matriz de pesos
        //imprimeMatriz(matrizPesos);
    }*/

    public static double[][] calcularNuevaMatrizDePesos(int[][] matrizEntrada, double[][] matrizPesos, int index, int di, double alfa){

        for (int i = 0; i < matrizPesos[0].length; i++) {
            matrizPesos[index][i] = matrizPesos[index][i]+(alfa*(matrizEntrada[di][i]-matrizPesos[index][i]));
            System.out.println(matrizPesos[index][i]);
        }
        System.out.println("\n");
        return matrizPesos;
    }

    /*public static int indiceMenor(double[] D) {
        int indice = 0;
        double minVal = D[0];

        for (int i=0; i<D.length; i++) {
            if (D[i] <= minVal) {
                indice = i;
                minVal = D[i];
            }
        }

        return indice;
    }*/

    public static int indiceMenor(double[] numbers) {

        if (numbers == null || numbers.length == 0)
            return -1;

        int minIdx = 0;
        double minVal = numbers[0];

        for(int idx=1; idx<numbers.length; idx++) {
            if(numbers[idx] <= minVal) {
                minVal = numbers[idx];
                minIdx = idx;
            }
        }
        return minIdx;
    }

    public static void imprimeMatriz(double[][] matriz) {
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



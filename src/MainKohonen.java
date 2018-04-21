import metodo.Kohonen;

import java.util.Arrays;

public class MainKohonen {

    // Topological Radius
    private static double R = 0;

    // Learning Rate at time zero
    private static double alfa = 0.6;

    private static double[][] matrizPesos = {
            {0.2, 0.6, 0.5, 0.9},
            {0.8, 0.4, 0.7, 0.3}
    };

    private static int matrizEntrada[][] = {
            {1, 1, 0, 0},
            {0, 0, 0, 1},
            {1, 0, 0, 0},
            {0, 0, 1, 1}
    };

    public static void main(String[] args) {

        for (int i=0; i<100; i++) {
            Kohonen.ENTRENAMIENTO(matrizEntrada, matrizPesos, alfa);
            alfa = alfa/2;
        }

        System.out.println("Matriz de pesos de entrenamiento OFICIAL");
        Kohonen.imprimeMatriz(matrizPesos);

        int nFilasEntradas = matrizEntrada.length;
        for (int i = 0; i < nFilasEntradas; i++) {
            int[] entradas = matrizEntrada[i];
            int cluster = Kohonen.EJECUCION(entradas, matrizPesos);
            System.out.println(Arrays.toString(entradas) + ", Cluster: " + cluster);
        }
    }
}

import metodo.Kohonen;

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
            Kohonen.calcularDistanciaEcladiana(matrizEntrada, matrizPesos, alfa);
            alfa = alfa/2;
        }

        //Kohonen.calcularDistanciaEcladiana(matrizEntrada, matrizPesos, alfa);

    }
}

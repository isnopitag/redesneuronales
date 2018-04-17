import metodo.Hopfield;

import java.util.Arrays;

public class MainHopfield {

    private static int[][] P1 = new int[4][4];
    private static int[][] P2 = new int[4][4];

    public static void main(String[] args) {
        /* Definición de patrones */
        definicionPatrones();

        System.out.println(" ------ MATRICES DE ENTRADA ------ ");

        System.out.println(" MATRIZ P1");
        Hopfield.imprimeMatriz(P1);
        System.out.println(" MATRIZ P2");
        Hopfield.imprimeMatriz(P2);

        /* Recuperacion */
        Hopfield.CalcularRecuperacion(P1, P2);

        /* Ortogonalidad */
        Hopfield.calcularDistanciaHamming(P1, P2);

        /* Entrenamiento */
        int[][] w = Hopfield.sumarMatrices(Hopfield.calcularMatrizEntrenamiento(P1), Hopfield.calcularMatrizEntrenamiento(P2));

        System.out.println("");
        System.out.println(" ------ MATRICES DE PESOS ------ ");
        Hopfield.imprimeMatriz(w);

        /* Ejecución */

        int[][] patronPruebaAnterior = new int[4][4];
        int[][] patronPrueba = new int[4][4];

        patronPrueba[0][0] = -1;
        patronPrueba[0][1] = 1;
        patronPrueba[0][2] = 1;
        patronPrueba[0][3] = 1;

        patronPrueba[1][0] = -1;
        patronPrueba[1][1] = 1;
        patronPrueba[1][2] = 1;
        patronPrueba[1][3] = 1;

        patronPrueba[2][0] = -1;
        patronPrueba[2][1] = 1;
        patronPrueba[2][2] = 1;
        patronPrueba[2][3] = 1;

        patronPrueba[3][0] = -1;
        patronPrueba[3][1] = 1;
        patronPrueba[3][2] = 1;
        patronPrueba[3][3] = 1;

        System.out.println(" ------ EJECUCIÓN DEL SISTEMA ------ ");

        int c = 1;
        while (!Arrays.deepEquals(patronPrueba, patronPruebaAnterior)) {
            patronPruebaAnterior = patronPrueba;

            System.out.println("");

            System.out.println(" -- MATRIZ DE ENTRADA");
            Hopfield.imprimeMatriz(patronPrueba);

            int[][] funcionEntrada = Hopfield.multiplicarMatrices(patronPrueba, w);
            System.out.println(" -- FUNCIÓN DE ENTRADA " + c);
            Hopfield.imprimeMatriz(funcionEntrada);

            int[][] funcionActivacion = Hopfield.calcularFuncionActivacion(funcionEntrada);
            System.out.println(" -- FUNCIÓN DE ACTIVACIÓN " + c);
            Hopfield.imprimeMatriz(funcionActivacion);

            int[][] funcionSalida = Hopfield.calcularFuncionSalida(funcionActivacion);
            System.out.println(" -- FUNCIÓN DE SALIDA " + c);
            Hopfield.imprimeMatriz(funcionSalida);

            c++;
            patronPrueba = funcionSalida;
        }
    }

    private static void definicionPatrones() {

        /*  -1  -1  1  -1
            -1  -1  1  -1
            -1  -1  1  -1
            -1  -1  1  -1  */

        P1[0][0] = -1;
        P1[0][1] = -1;
        P1[0][2] = 1;
        P1[0][3] = -1;

        P1[1][0] = -1;
        P1[1][1] = -1;
        P1[1][2] = 1;
        P1[1][3] = -1;

        P1[2][0] = -1;
        P1[2][1] = -1;
        P1[2][2] = 1;
        P1[2][3] = -1;

        P1[3][0] = -1;
        P1[3][1] = -1;
        P1[3][2] = 1;
        P1[3][3] = -1;

        /*  1  1  1  1
            1 -1 -1  1
            1 -1 -1  1
            1  1  1  1  */

        P2[0][0] = 1;
        P2[0][1] = 1;
        P2[0][2] = 1;
        P2[0][3] = 1;

        P2[1][0] = 1;
        P2[1][1] = -1;
        P2[1][2] = -1;
        P2[1][3] = 1;

        P2[2][0] = 1;
        P2[2][1] = -1;
        P2[2][2] = -1;
        P2[2][3] = 1;

        P2[3][0] = 1;
        P2[3][1] = 1;
        P2[3][2] = 1;
        P2[3][3] = 1;
    }
}

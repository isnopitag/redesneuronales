import metodo.Hopfield;

public class MainHopfield {

    private static int[][] P1 = new int[4][4];
    private static int[][] P2 = new int[4][4];

    public static void main(String[] args) {
        /* Definición de patrones */
        definicionPatrones();

        /* Recuperacion */
        Hopfield.CalcularRecuperacion(P1, P2);

        /* Ortogonalidad */
        Hopfield.calcularDistanciaHamming(P1, P2);

        /* Entrenamiento*/
        int[][] w = Hopfield.sumarMatrices(Hopfield.calcularMatrizEntrenamiento(P1), Hopfield.calcularMatrizEntrenamiento(P2));
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
import metodo.Backpropagation;

public class MainBackpropagation {

    private static int[][] entrada = {
            {1,1},
            {1,0},
            {0,1},
            {0,0}
    };

    //Capas*Entradas+capas= dimension pesos
    // matrizpesos[capas][Dimension pesos]
    private static double[][] pesos = {
            {0.8, 0.4, 0.3},
            {0.2, 0.9, 0.5}
    };

    private static double[] pesos2 ={0.3, 0.5, 0.9};


    /*private static double[][] pesos = {
            {0.8, 0.4, 0.3},
            {0.2, 0.9, 0.5},
            {0.3, 0.5, 0.9}
    };*/

    private static int[] salida = {0,1,1,0};

    private static int capasOcultas = 3;

    public static void main(String[] args) {
        Backpropagation.haciaAdelante(entrada,salida,pesos,pesos2,capasOcultas);
    }
}

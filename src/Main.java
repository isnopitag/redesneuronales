import model.Item;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Item> redNeuronal = new ArrayList<>();

    private static double limite = 0.2;    // Representa la letra griega tetha Valor utlizado en la resta de la sumatoria, posibles valores entre el rago [0, 1]
    private static double coefAP = 0.1;    // Representa la letra griega alpha Valor utilizado para el error

    public static void main(String[] args) {
        valoresEntrada(redNeuronal, new double[]{ 0.3, -0.1 });

        Perceptron.calculoSumatoria(redNeuronal.get(0), limite); // Calculo para la primer sumatoria
    }

    private static void valoresEntrada(ArrayList<Item> redNeuronal, double[] pesosIniciales) {
        redNeuronal.add(new Item(
                new int[]{ 1, 1 },       /* Variables x1, x2, ... xn */
                1,             /* Y deseada */
                pesosIniciales          /* Pesos Inicialies */
        ));

        redNeuronal.add(new Item(
                new int[]{ 1, 0 },      /* Variables x1, x2, ... xn */
                0             /* Y deseada */
        ));

        redNeuronal.add(new Item(
                new int[]{ 0, 1 },      /* Variables x1, x2, ... xn */
                0             /* Y deseada */
        ));

        redNeuronal.add(new Item(
                new int[]{ 0, 0 },      /* Variables x1, x2, ... xn */
                0             /* Y deseada */
        ));
    }
}

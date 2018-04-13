import Ejercicios.Perceptron;
import model.Modelo;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Modelo> redNeuronal;

    private static double limite = 0.2;    // Representa la letra griega tetha Valor utlizado en la resta de la sumatoria, posibles valores entre el rago [0, 1]
    private static double coefAP = 0.1;    // Representa la letra griega alpha Valor utilizado para el error

    private static double[] pesosIniciales = new double[]{0.3, -0.1};

    public static void main(String[] args) {

        int etapa = 1;
        boolean statusError = true; // El statusError será verdadero, si alguno de sus elementos no es cero
                                    // El statusError será falso, si todos sus elementos son cero
        while(statusError) {

            System.out.println("Etapa " + etapa);
            valoresEntrada(redNeuronal, pesosIniciales);

            for (int i=0; i<redNeuronal.size(); i++) {
                Modelo item = redNeuronal.get(i);

                Perceptron.calculoSumatoria(item, limite);
                Perceptron.calcularFuncionEntrada(item);
                Perceptron.calcularFuncionActivacion(item);
                Perceptron.calcularFuncionSalida(item);
                Perceptron.calcularError(item);
                Perceptron.calcularIncrementosW(item, coefAP);
            }

            if (Perceptron.statusError(redNeuronal)) {
               // Tiene errores
                pesosIniciales = redNeuronal.get(redNeuronal.size() - 1).getIncrementoW();  // Obtenemos los ultimos pesos para la siguiente etapa
            } else {
                // No tiene errores
                statusError = false;
                System.out.println("La red ha terminado de aprender");
            }
        }


        Perceptron.calculoSumatoria(redNeuronal.get(0), limite); // Calculo para la primer sumatoria
    }

    private static void valoresEntrada(ArrayList<Modelo> redNeuronal, double[] pesosIniciales) {
        redNeuronal = new ArrayList<>();

        redNeuronal.add(new Modelo(
                new int[]{ 1, 1 },       /* Variables x1, x2, ... xn */
                1,             /* Y deseada */
                pesosIniciales          /* Pesos Inicialies */
        ));

        redNeuronal.add(new Modelo(
                new int[]{ 1, 0 },      /* Variables x1, x2, ... xn */
                0             /* Y deseada */
        ));

        redNeuronal.add(new Modelo(
                new int[]{ 0, 1 },      /* Variables x1, x2, ... xn */
                0             /* Y deseada */
        ));

        redNeuronal.add(new Modelo(
                new int[]{ 0, 0 },      /* Variables x1, x2, ... xn */
                0             /* Y deseada */
        ));
    }
}

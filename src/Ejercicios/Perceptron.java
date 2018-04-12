package Ejercicios;

public class Perceptron {

    public static double calculoSumatoria(Item item, double limite) {
        double result = 0.0;

        int[] variables = item.getVariablesX();
        double[] pesos = item.getPesosW();

        double sum = 0.0;
        for (int i=0; i<variables.length; i++) {

            double aux = variables[i] * pesos[i];
            sum = sum + aux;
        }

        DecimalFormat df = new DecimalFormat("#.#");

        System.out.println("SUM: " + df.format(sum));
        System.out.println("LIM: " + df.format(limite));
        result = sum - limite;

        System.out.println("Result: " + df.format(result));
        return result;
    }
}

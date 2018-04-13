package Ejercicios;

import model.Modelo;

import java.text.DecimalFormat;

public class Perceptron {

    public static double calculoSumatoria(Modelo item, double limite) {
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

    public static void calcularFuncionActivacion(Modelo item,double funcionEntrada){
        if(funcionEntrada>0){
            item.setFuncionActivacion(1);
        }else{
            if (funcionEntrada<=0)
            item.setFuncionActivacion(0);
        }
    }


}

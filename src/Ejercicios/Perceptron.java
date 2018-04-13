package Ejercicios;

import model.Modelo;

import java.text.DecimalFormat;

public class Perceptron {

    public static void calculoSumatoria(Modelo item, double limite) {
        double resultado = 0.0;

        int[] variables = item.getVariablesX();
        double[] pesos = item.getPesosW();

        double sumatoria = 0.0;
        for (int i=0; i<variables.length; i++) {
            sumatoria += variables[i] * pesos[i];
        }

        DecimalFormat df = new DecimalFormat("#.#");
        resultado = sumatoria - limite;

        item.setSumatoria(resultado);
    }

    public static void calcularFuncionEntrada(Modelo item, double valorSumatoria) {

    }

    public static void calcularFuncionActivacion(Modelo item, double funcionEntrada){
        if(funcionEntrada>0){
            item.setFuncionActivacion(1);
        }else{
            if (funcionEntrada<=0)
            item.setFuncionActivacion(0);
        }
    }

}

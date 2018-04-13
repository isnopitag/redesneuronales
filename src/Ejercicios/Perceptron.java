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

    public static void calcularFuncionEntrada(Modelo item) {
        item.setFuncionEntrada(item.getSumatoria());
    }

    public static void calcularFuncionActivacion(Modelo item){
        if(item.getFuncionEntrada()>0){
            item.setFuncionActivacion(1);
        }else{
            if (item.getFuncionEntrada()<=0)
                item.setFuncionActivacion(0);
        }
    }

    public static  void calcularFuncionSalida(Modelo item){
        item.setFuncionSalida(item.getFuncionActivacion());
    }

    public static void calcularError(Modelo item) {
        item.setError(item.getYDeseada() - item.getFuncionSalida());
    }

    public static void calcularIncrementosW(Modelo item, double coefAP) {

        int[] variablesX = item.getVariablesX();
        double[] incrementosW = new double[variablesX.length];

        for (int i=0; i<variablesX.length; i++) {
            incrementosW[i] = coefAP * variablesX[i] * item.getError();
        }

        item.setIncrementoW(incrementosW);
    }
}

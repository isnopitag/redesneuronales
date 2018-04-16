package metodo;

import model.Modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Perceptron {

    public static void calculoSumatoria(Modelo item, double limite) {
        double resultado = 0.0;

        int[] variables = item.getVariablesX();
        double[] pesos = item.getPesosW();

        double sumatoria = 0.0;
        for (int i=0; i<variables.length; i++) {
            sumatoria += variables[i] * pesos[i];
        }

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

    public static double[] calcularNuevosPesos(double[] pesos, double[] incrementos) {
        double[] resultado = new double[pesos.length];
        for (int i=0; i<pesos.length; i++) {
            resultado[i] = pesos[i] + incrementos[i];
        }

        return resultado;
    }

    public static boolean statusError(ArrayList<Modelo> redNeuronal) {
        boolean resultado = false;

        for (int i=0; i<redNeuronal.size(); i++) {
            Modelo item = redNeuronal.get(i);

            if (item.getError() > 0 || item.getError() < 0) {
                resultado = true;
            }
        }

        return resultado;
    }

    public static void imprimeResultados(ArrayList<Modelo> redNeuronal) {
        System.out.println("Variables - Y Deseada - Pesos - Sumatoria - Funcion Entrada - Funcion Activacion - Funcion Salida - Error - Incrementos");
        for (int i=0; i<redNeuronal.size(); i++) {
            Modelo item = redNeuronal.get(i);
            System.out.println(Arrays.toString(item.getVariablesX()) + " - " + item.getYDeseada() + " - " + Arrays.toString(item.getPesosW()) + " - " + String.format("%.1f", item.getSumatoria()) + " - " + String.format("%.1f", item.getFuncionEntrada()) + " - " + item.getFuncionActivacion() + " - " + item.getFuncionSalida() + " - " + item.getError() + " - " + Arrays.toString(item.getIncrementoW()));
        }
    }
}

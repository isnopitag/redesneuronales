package model;

public class Modelo {

    /**
     * variablesX, pesosW y incrementoW tienen la misma longitud, a cada variable le corresponde un peso
     */

    private int[] variablesX;
    private int YDeseada;
    private double[] pesosW;
    private double sumatoria;
    private double funcionEntrada;
    private double funcionActivacion;
    private double funcionSalida;
    private double error;
    private double[] incrementoW;

    public Modelo(int[] variablesX, int YDeseada, double[] pesosW) {
        this.variablesX = variablesX;
        this.YDeseada = YDeseada;
        this.pesosW = pesosW;
    }

    public Modelo(int[] variablesX, int YDeseada) {
        this.variablesX = variablesX;
        this.YDeseada = YDeseada;
    }


    public int[] getVariablesX() {
        return variablesX;
    }

    public void setVariablesX(int[] variablesX) {
        this.variablesX = variablesX;
    }

    public int getYDeseada() {
        return YDeseada;
    }

    public void setYDeseada(int YDeseada) {
        this.YDeseada = YDeseada;
    }

    public double[] getPesosW() {
        return pesosW;
    }

    public void setPesosW(double[] pesosW) {
        this.pesosW = pesosW;
    }

    public double getSumatoria() {
        return sumatoria;
    }

    public void setSumatoria(double sumatoria) {
        this.sumatoria = sumatoria;
    }

    public double getFuncionEntrada() {
        return funcionEntrada;
    }

    public void setFuncionEntrada(double funcionEntrada) {
        this.funcionEntrada = funcionEntrada;
    }

    public double getFuncionActivacion() {
        return funcionActivacion;
    }

    public void setFuncionActivacion(double funcionActivacion) {
        this.funcionActivacion = funcionActivacion;
    }

    public double getFuncionSalida() {
        return funcionSalida;
    }

    public void setFuncionSalida(double funcionSalida) {
        this.funcionSalida = funcionSalida;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    public double[] getIncrementoW() {
        return incrementoW;
    }

    public void setIncrementoW(double[] incrementoW) {
        this.incrementoW = incrementoW;
    }
}

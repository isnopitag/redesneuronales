package metodo;

import java.util.Arrays;

public class Backpropagation {

    private  static double[] capas;
    private  static double[] capasSig;

    public static void haciaAdelante(int[][] entrada, int[] salida, double[][] pesos, double[] pesos2,int capasOcultas){


        //System.out.println(test);
        System.out.println(entrada.length+" "+entrada[0].length+" "+pesos.length+" "+pesos[0].length);

        //for (int i = 0; i <entrada.length ; i++) {
            int corrida=0;
            do {
                capas  = new double[capasOcultas];
                capasSig  = new double[capasOcultas];

            for (int j = 0; j < entrada[0].length; j++) {
                int l=0;
                while (l<pesos[0].length){
                    //System.out.println(0+" "+" "+j+" "+l+" "+entrada[0][j]*pesos[j][l]);
                    capas[l]+=(entrada[0][j]*pesos[j][l]);
                    l++;
                }
            }

        for (int i = 0; i <capas.length ; i++) {
                //System.out.println(capas[i]);
            capasSig[i]=funcionSigmoidial(capas[i]);
        }

        double resultado=0;

        for (int i = 0; i < capasSig.length; i++) {
            resultado+=(capasSig[i]*pesos2[i]);
        }
        //BackPropagation
        double resFunAct = funcionSigmoidial(resultado);

        double error = calcularError(resFunAct,salida,0);

        double saidaDelta=(derivadaSigmodial(resultado)*error);

        //Calcular nuevos pesos

        double[] PesosDelta = new double[capasSig.length];
        double[] Pesos2new = new double[pesos2.length];

        for (int i = 0; i < capasSig.length; i++) {
            PesosDelta[i]=(saidaDelta/capasSig[i]);
            Pesos2new[i]=(pesos2[i]+PesosDelta[i]);
        }
        //Calcular delta hidden sum
        double[] dHsum = new double[capas.length];
        for (int i = 0; i <capas.length ; i++) {
            dHsum[i]=((saidaDelta/pesos2[i])*derivadaSigmodial(capas[i]));
        }

        //Calcular los pesos capa primera
        double[][] DeltaPesos = new double[pesos.length][pesos[0].length];
        double[][] nuevosPesos = new double[pesos.length][pesos[0].length];

        for (int i = 0; i <pesos.length ; i++) {
            for (int j = 0; j <pesos[0].length ; j++) {
                DeltaPesos[i][j]=(dHsum[j]/entrada[0][i]);
                nuevosPesos[i][j]=(pesos[i][j]+DeltaPesos[i][j]);
            }
        }
        System.out.println(Arrays.toString(capas)+"\n"+Arrays.toString(capasSig)+"\n"+resultado+"\n"+resFunAct+"\n"+error+"\n"+saidaDelta+"\n"+Arrays.toString(PesosDelta)+"\n"+Arrays.toString(Pesos2new)+"\n"+Arrays.toString(dHsum)+"\n"+Arrays.deepToString(DeltaPesos)+"\n"+Arrays.deepToString(nuevosPesos));
        System.out.println("======================================================");

        //Actualizacion de Pesos
        pesos = nuevosPesos;
        pesos2= Pesos2new;
        corrida++;
        }while (corrida<=1);

    }

    public static double derivadaSigmodial(double x){
        double derivada;
        derivada = (funcionSigmoidial(x)*(1-funcionSigmoidial(x)));
        return derivada;
    }

    public static double funcionSigmoidial(double x){
        double res=0.0;
        res=(1/(1+Math.exp(-x)));
        return res;

    }

    public static double calcularError(double calculado,int[] salida,int index){
        double error;
        error=salida[index]-calculado;
        return error;
    }

    public static void imprimeMatriz(double[][] matriz) {
        String strMatriz = "";
        for (int x=0; x<matriz.length; x++) {
            for (int y=0; y<matriz[x].length; y++) {
                strMatriz += matriz[x][y] + " ";
            }
            strMatriz += "\n";
        }
        System.out.println(strMatriz);
    }
}

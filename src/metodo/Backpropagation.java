package metodo;

import java.util.Arrays;

public class Backpropagation {

    private static double[] capas;
    private static double[] capasSig;

    public static void main(int[][] entrada, int[] salida, double[][] pesos, double[] pesos2, int capasOcultas) {

        int corrida = 0;
        do {
            capas = new double[capasOcultas];
            capasSig = new double[capasOcultas];

            //Propagacion hacia adelante
            for (int j = 0; j < entrada[0].length; j++) {
                int l = 0;
                while (l < pesos[0].length) {
                    capas[l] += (entrada[0][j] * pesos[j][l]);
                    l++;
                }
            }

            for (int i = 0; i < capas.length; i++) {
                capasSig[i] = funcionSigmoidial(capas[i]);
            }

            double resultado = 0;
            for (int i = 0; i < capasSig.length; i++) {
                resultado += (capasSig[i] * pesos2[i]);
            }

            //BackPropagation
            double resFunAct = funcionSigmoidial(resultado);

            double error = calcularError(resFunAct, salida, 0);

            double sumDelta = (derivadaSigmodial(resultado) * error);

            //Calcular nuevos pesos de las capas ocultas

            double[] PesosDelta = new double[capasSig.length];
            double[] PesosHnew = new double[pesos2.length];

            for (int i = 0; i < capasSig.length; i++) {
                PesosDelta[i] = (sumDelta / capasSig[i]);
                PesosHnew[i] = (pesos2[i] + PesosDelta[i]);
            }
            //Calcular delta hidden sum
            double[] dHsum = new double[capas.length];
            for (int i = 0; i < capas.length; i++) {
                dHsum[i] = ((sumDelta / pesos2[i]) * derivadaSigmodial(capas[i]));
            }

            //Calcular los pesos capa primera
            double[][] DeltaPesos = new double[pesos.length][pesos[0].length];
            double[][] nuevosPesos = new double[pesos.length][pesos[0].length];

            for (int i = 0; i < pesos.length; i++) {
                for (int j = 0; j < pesos[0].length; j++) {
                    DeltaPesos[i][j] = (dHsum[j] / entrada[0][i]);
                    nuevosPesos[i][j] = (pesos[i][j] + DeltaPesos[i][j]);
                }
            }

            //SALIDAS PARA LA CONSOLA
            System.out.println("Corrida: " + corrida + "\n");
            System.out.println("Entradas: " + entrada[0][0] + " " + entrada[0][1] + "\n");
            System.out.println("Salida Deseada: " + salida[0] + "\n");
            System.out.println("{{1era Fase Propagacion hacia adelante}}\n");
            System.out.println("Pesos para " + capasOcultas + " capas ocultas");
            System.out.println(Arrays.deepToString(pesos) + "\n");
            System.out.println("Pesos de las capas ocultas");
            System.out.println(Arrays.toString(pesos2) + "\n");
            System.out.println("Sumatorias de las entradas con las capas ocultas");
            System.out.println(Arrays.toString(capas) + "\n");
            System.out.println("Sumatoria aplicando la Funcion de Activación Sigmoidial");
            System.out.println(Arrays.toString(capasSig) + "\n");
            System.out.println("Sumatoria Obtenida: " + resultado + "\n");
            System.out.println("++++++++++++++");
            System.out.println("Salida Deseada: " + salida[0] + " Salida Calculada: " + resFunAct);
            System.out.println("++++++++++++++\n");
            System.out.println("{{2nda Fase Propagacion hacia atras}}\n");
            System.out.println("Error Calculado: " + error + "\n");
            System.out.println("Sumatoria Delta: " + sumDelta + "\n");
            System.out.println("Pesos Delta");
            System.out.println(Arrays.toString(PesosDelta) + "\n");
            System.out.println("Nuevos pesos para las capas ocultas");
            System.out.println(Arrays.toString(PesosHnew) + "\n");
            System.out.println("Sumatoria Delta de capas ocultas (dHsum)");
            System.out.println(Arrays.toString(dHsum) + "\n");
            System.out.println("Pesos Delta");
            System.out.println(Arrays.deepToString(DeltaPesos) + "\n");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("Pesos Viejos");
            System.out.println(Arrays.deepToString(pesos) + "\n");
            System.out.println("Pesos Nuevos");
            System.out.println(Arrays.deepToString(nuevosPesos) + "\n");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("======================================================");

            //Actualizacion de Pesos para las siguientes corridas
            pesos = nuevosPesos;
            pesos2 = PesosHnew;
            corrida++;
        } while (corrida <= 10000);

    }

    public static double derivadaSigmodial(double x) {
        double derivada;
        derivada = (funcionSigmoidial(x) * (1 - funcionSigmoidial(x)));
        return derivada;
    }

    public static double funcionSigmoidial(double x) {
        double res = 0.0;
        res = (1 / (1 + Math.exp(-x)));
        return res;

    }

    public static double calcularError(double calculado, int[] salida, int index) {
        double error;
        error = salida[index] - calculado;
        return error;
    }
}

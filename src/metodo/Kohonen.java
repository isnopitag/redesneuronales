package metodo;

public class Kohonen {

        public static void calcularDistanciaEcladiana(int[][] matrizEntrada, double[][] matrizPesos, double alfa){

            for (int i = 0; i < matrizEntrada.length; i++) {
                double d[] = new double[matrizPesos.length];
                for (int j = 0; j < matrizPesos[0].length ; j++) {
                    for (int k = 0; k < matrizPesos.length ; k++) {
                        //System.out.println(matrizEntrada[i][j]+" "+matrizPesos[k][j]);
                        d[k]+= Math.pow((matrizEntrada[i][j] - matrizPesos[k][j]), 2);
                    }

                }
                //System.out.println(min(d));
                matrizPesos=calcularNuevaMatrizDePesos(matrizEntrada,matrizPesos,min(d),i,alfa);

            }

        }

        public static double[][] calcularNuevaMatrizDePesos(int[][] matrizEntrada,double[][] matrizPesos, int index,int di,double alfa){

            for (int i = 0; i < matrizPesos[0].length; i++) {
                matrizPesos[index][i] = matrizPesos[index][i]+(alfa*(matrizEntrada[di][i]-matrizPesos[index][i]));
                System.out.println(matrizPesos[index][i]);
            }
            //System.out.println("\n");
            return matrizPesos;
        }

    public static void imprimeArrayDouble(double[] arrayDistancia) {
        String strMatriz = "";
        for (int x=0; x<arrayDistancia.length; x++) {
                strMatriz += arrayDistancia[x]+ " ";
            strMatriz += "\n";
        }
        System.out.println(strMatriz);
    }

    public static int obtenerMenorDistancia(double[] arrayDistancia){
            double menor=0.0;
            int    index=0;
        for (int i = 1; i < arrayDistancia.length; i++) {
            if(menor>arrayDistancia[i]){
                menor=arrayDistancia[i];
                index=i;
            }
        }
        return index;
    }

    public static int min(double[] numbers) {
        if (numbers == null || numbers.length == 0) return -1; // Saves time for empty array
        // As pointed out by ZouZou, you can save an iteration by assuming the first index is the smallest
        double minVal = numbers[0]; // Keeps a running count of the smallest value so far
        int minIdx = 0; // Will store the index of minVal
        for(int idx=1; idx<numbers.length; idx++) {
            if(numbers[idx] <= minVal) {
                minVal = numbers[idx];
                minIdx = idx;
            }
        }
        return minIdx;
    }


}



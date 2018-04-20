package metodo;

public class Kohonen {

        public static void calcularDistanciaEcladiana(int[][] matrizEntrada, double[][] matrizPesos, double alfa){

            for (int i = 0; i < matrizEntrada.length; i++) {
                double d[] = new double[matrizPesos.length];
                for (int j = 0; j < matrizPesos[0].length ; j++) {
                    for (int k = 0; k < matrizPesos.length ; k++) {
                        d[k]+= Math.pow((matrizEntrada[i][j] - matrizPesos[k][j]), 2);
                    }
                }
                matrizPesos=calcularNuevaMatrizDePesos(matrizEntrada,matrizPesos,indiceMenor(d),i,alfa);
            }
            //Solo para debugear que este vien la matriz de pesos
            imprimeMatriz(matrizPesos);

        }

        public static double[][] calcularNuevaMatrizDePesos(int[][] matrizEntrada,double[][] matrizPesos, int index,int di,double alfa){

            for (int i = 0; i < matrizPesos[0].length; i++) {
                matrizPesos[index][i] = matrizPesos[index][i]+(alfa*(matrizEntrada[di][i]-matrizPesos[index][i]));
                System.out.println(matrizPesos[index][i]);
            }
            System.out.println("\n");
            return matrizPesos;
        }

    public static int indiceMenor(double[] numbers) {
        if (numbers == null || numbers.length == 0) return -1;
        double minVal = numbers[0];
        int minIdx = 0;
        for(int idx=1; idx<numbers.length; idx++) {
            if(numbers[idx] <= minVal) {
                minVal = numbers[idx];
                minIdx = idx;
            }
        }
        return minIdx;
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



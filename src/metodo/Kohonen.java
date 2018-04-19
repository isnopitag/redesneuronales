package metodo;

public class Kohonen {

        public static void calcularDistanciaEcladiana(int[][] matrizEntrada, double[][] matrizPesos){

            for (int i = 0; i < matrizEntrada.length; i++) {
                double d[] = new double[matrizPesos.length];
                for (int j = 0; j < matrizPesos[0].length ; j++) {
                    for (int k = 0; k < matrizPesos.length ; k++) {
                        //System.out.println(matrizEntrada[i][j]+" "+matrizPesos[k][j]);
                        d[k]+= Math.pow((matrizEntrada[i][j] - matrizPesos[k][j]), 2);
                    }

                }

            }

        }

        public static void calcularNuevaMatrizDePesos(double[][] matrizPesos, int index){
            double nuevaMatrizPesos[][];
            for (int i = 0; i < matrizPesos.length; i++) {
                
            }
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
        for (int i = 0; i < arrayDistancia.length; i++) {
            if(i==0){
                menor=arrayDistancia[i];
                index=0;
            }else if(menor>arrayDistancia[i]){
                menor=arrayDistancia[i];
                index=i;
            }
        }
        return index;
    }
}



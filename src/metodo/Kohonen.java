package metodo;

public class Kohonen {

    public static void calcularDistanciaEcladiana(int[][] matrizEntrada, double[][] matrizPesos){

        double d[] = new double[matrizPesos.length];
        System.out.println(matrizEntrada.length+" "+matrizPesos.length+" "+matrizPesos[0].length);

        for (int j=0;j<matrizEntrada.length;j++){
            for (int k=0; k<matrizPesos[0].length;k++){
                for (int i=0;i<matrizPesos.length;i++) {
                    /*d[i]+=Math.pow((matrizEntrada[k][j] - matrizPesos[k][i]),2);
                    System.out.println(matrizEntrada[i][j] + " " + matrizPesos[k][i]+" "+d[i]);*/
                    //System.out.println(matrizEntrada[k][j] + " " + matrizPesos[j][i]);
                    if(i==0){
                        d[0]+=Math.pow((matrizEntrada[k][j] - matrizPesos[i][k]),2);
                       // System.out.println(matrizEntrada[k][j]+ " " + matrizPesos[i][k]);
                        System.out.println(""+i);
                    }if(i%2==0){
                            d[1]+=Math.pow((matrizEntrada[k][j] - matrizPesos[i][k]),2);
                          //  System.out.println(matrizEntrada[k][j]+ " " + matrizPesos[i][k]);
                        System.out.println(""+i);
                    }else{
                        if(i%2!=0){
                            d[0]+=Math.pow((matrizEntrada[k][j] - matrizPesos[i][k]),2);
                            //System.out.println(matrizEntrada[k][j]+ " " + matrizPesos[i][k]);
                        System.out.println(""+i);
                        }}
                    }
                }
                //System.out.println(matrizEntrada[k][j] + " " + matrizPesos[0][k]);
            }
            System.out.println(d[0]+"   "+d[1]+"\n");
        }
}



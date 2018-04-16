import metodo.Hopfield;

public class MainHopfield {

    private static int[] P1 = new int[]{
            -1, -1, 1, -1,
            -1, -1, 1, -1,
            -1, -1, 1, -1,
            -1, -1, 1, -1
    };

    private static int[] P2 = new int[]{
            1, 1, 1, 1,
            1, -1, -1, 1,
            1, -1, -1, 1,
            1, 1, 1, 1
    };

    public static void main(String[] args) {

        int[][] matrizEntrenamientoP1 = Hopfield.calcularMatrizEntrenamiento(P1);

        String row = "";
        for (int x=0; x<matrizEntrenamientoP1.length; x++) {
            for (int y=0; y<matrizEntrenamientoP1[x].length; y++) {
                row += matrizEntrenamientoP1[x][y] + " ";
            }
            row += "\n";
        }

        System.out.println(row);
    }
}

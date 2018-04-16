package metodo;

public class Hopfield {

    /**
     * Calcula la matriz por su matriz transpuesta menos la matriz identidad
     * MxM(T) - I
     */

    public static int[][] calcularMatrizEntrenamiento(int[] matriz) {

        int[] matrizT = matriz; // Matriz Transpuesta (solo de una dimension)
        int[][] matrizResultante = new int[matriz.length][matrizT.length];

        for (int x=0; x<matriz.length; x++) {
            for (int y=0; y<matrizT.length; y++) {
                matrizResultante[x][y] = matriz[x] * matriz[y];
            }
        }

        return matrizResultante;
    }
}

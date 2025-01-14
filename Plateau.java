import java.util.*;

public class Plateau {
    public static void main(String[] args) {
        Case name = new Case();
        String[][] arrays = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                arrays[i][j] = name.name;
            }
        }
        System.out.println("Comment le plateau est codé :");
        System.out.println(Arrays.deepToString(arrays));
        System.out.println("Affichage du plateau :");
        for (String[] row : arrays) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

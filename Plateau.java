import java.util.*;

public class Plateau {
    static Case name = new Case();
    public static void main(String[] args) {
        String[][] plateau = newPlateau();
        System.out.println("Comment le plateau est codé :");
        System.out.println(Arrays.deepToString(plateau));
        System.out.println("Affichage du plateau :");
        for (String[] row : plateau) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    public static String[][] newPlateau() {
        String[][] plateau = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                plateau[i][j] = name.name;
            }
        }
        return plateau;



    }
}

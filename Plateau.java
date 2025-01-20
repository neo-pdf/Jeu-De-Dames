import java.util.*;

public class Plateau {
    static Case name = new Case();
    public static void main(String[] args) {
        String[][] plateau = newPlateau();
        System.out.println("Comment le plateau est code :");
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
                if ((i >= 3 && i <= 4) || (i%2 == 0 && j%2 == 1 || i%2 == 1 && j%2 == 0)) {
                    plateau[i][j] = name.name;
                } else {
                    plateau[i][j] = "C";
                }
            }
        }
        return plateau;
    }
}

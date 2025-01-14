/*  Donc là tu as deux fichiers: Plateau et Case.
    Le plateau c'est juste l'ensemble des cases
    Les cases pour l'instant c'est juste un string qui écrit C.
 */


// Permet l'affichage du plateau
import java.util.*;

public class Plateau {
    public static void main(String[] args) {
        // Pour utiliser la classe Case
        Case name = new Case();
        // Création du plateau
        String[][] arrays = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Chaque case va s'appeler C
                arrays[i][j] = name.name;
            }
        }
        // Juste l'affichage du plateau tel qu'il est codé
        System.out.println("Comment le plateau est codé :");
        System.out.println(Arrays.deepToString(arrays));
        // Une manière de l'afficher (on va l'améliorer au fur et à mesure du temps)
        System.out.println("Affichage du plateau :");
        for (String[] row : arrays) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

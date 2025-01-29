import java.util.Scanner;
import java.util.List;

public class Jeu {
    private final Plateau plateau;
    private final Joueur joueur1;
    private final Joueur joueur2;
    private boolean jeuEnCours;
    private boolean tourJoueur1;
    private final Scanner scanner;

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.nouveauJeu();
    }

    public Jeu() {
        this.plateau = new Plateau();
        this.joueur1 = new Joueur();
        this.joueur2 = new Joueur();
        joueur1.setCouleur("R");
        joueur2.setCouleur("V");
        this.jeuEnCours = true;
        this.tourJoueur1 = true;
        this.scanner = new Scanner(System.in);
    }

    public void nouveauJeu() {
        System.out.println("Bienvenue dans le jeu de dames !");
        nomsDesJoueurs();
        while (jeuEnCours) {
            plateau.affichePlateau();
            jouerTour();
        }
    }

    private void nomsDesJoueurs() {
        System.out.println("Joueur 1, choisissez votre nom:");
        joueur1.setNom();
        System.out.println("Joueur 2, choisissez votre nom:");
        joueur2.setNom();
    }

    private void jouerTour() {
        Joueur joueurActuel = tourJoueur1 ? joueur1 : joueur2;
        System.out.println("C'est au tour de " + joueurActuel.getNom() + ".");
        System.out.println("Entrez l'indice de la case de départ (1-50) : ");
        int caseDepart = scanner.nextInt() - 1;

        Piece pieceDepart = plateau.getPlateau().get(caseDepart).getPiece();
        if (pieceDepart == null || !pieceDepart.getColor().equals(joueurActuel.getCouleur())) {
            System.out.println("Mouvement invalide : la case n'a pas de pion de la bonne couleur");
            return;
        }
        List<Integer> mouvementsPossibles = pieceDepart.mouvementsPossibles(caseDepart);
        System.out.println("Mouvements possibles : " + mouvementsPossibles);

        System.out.println("Entrez l'indice de la case d'arrivée (1-50) : ");
        int caseArrivee = scanner.nextInt() - 1;

        if (!mouvementsPossibles.contains(caseArrivee)) {
            System.out.println("Mouvement invalide : vous ne pouvez pas déplacer le pion à cette case.");
            return;
        }
        plateau.getPlateau().get(caseArrivee).setPiece(pieceDepart);
        plateau.getPlateau().get(caseDepart).retirerPiece();


        tourJoueur1 = !tourJoueur1;

        finDuJeu();
    }

    private void finDuJeu() {
        if (joueur1.getPieceRestante() == 0) {
            System.out.println("Le vainqueur est " + joueur2.getNom());
            jeuEnCours = false;
        } else if (joueur2.getPieceRestante() == 0) {
            System.out.println("Le vainqueur est " + joueur1.getNom());
            jeuEnCours = false;
        }
    }
}

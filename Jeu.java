import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
        this.joueur1 = new Joueur("R");
        this.joueur2 = new Joueur("V");
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
        System.out.println("Entrez l'indice de la case de depart (1-50) : ");
        int caseDepart = scanner.nextInt() - 1;

        if (caseDepart < 0 || caseDepart >= 50) {
            System.out.println("Indice de case invalide. Veuillez entrer un nombre entre 1 et 50.");
            return;
        }

        Piece pieceDepart = plateau.getPlateau().get(caseDepart).getPiece();
        if (pieceDepart == null) {
            System.out.println("Mouvement invalide : la case n'a pas de pion.");
            return;
        }
        if (!pieceDepart.getColor().equals(joueurActuel.getCouleur())) {
            System.out.println("Mouvement invalide : la case n'a pas de pion de la bonne couleur.");
            return;
        }

        List<Integer> mouvementsPossibles = pieceDepart.mouvementsPossibles(caseDepart, plateau.getPlateau());
        if (mouvementsPossibles.isEmpty()) {
            System.out.println("Aucun mouvement possible avec cette piece.");
            return;
        }
        System.out.println("Mouvements possibles : " + mouvementsPossibles);

        boolean captureEffectuee = false;
        while (true) {
            System.out.println("Entrez l'indice de la case d'arrivee (1-50) : ");
            int caseArrivee = scanner.nextInt() - 1;

            if (!mouvementsPossibles.contains(caseArrivee + 1)) { // Ajouter 1 a l'index
                System.out.println("Mouvement invalide : vous ne pouvez pas deplacer le pion a cette case.");
                return;
            }

            // Vérifier si c'est une capture
            int delta = caseArrivee - caseDepart;
            if (Math.abs(delta) == 10 || Math.abs(delta) == 12) {
                int caseCapture = caseDepart + delta / 2;
                plateau.getPlateau().get(caseCapture).retirerPiece();
                joueurActuel.setPieceRestante(joueurActuel.getPieceRestante() - 1);
                captureEffectuee = true;
                System.out.println("Capture effectuee ! Vous allez a la case " + (caseArrivee + 1) + ".");
            }

            plateau.getPlateau().get(caseArrivee).setPiece(pieceDepart);
            plateau.getPlateau().get(caseDepart).retirerPiece();

            if (!captureEffectuee) {
                break;
            }

            caseDepart = caseArrivee;
            mouvementsPossibles = pieceDepart.mouvementsPossibles(caseDepart, plateau.getPlateau());
            if (mouvementsPossibles.isEmpty() || !peutEffectuerCapture(caseDepart, mouvementsPossibles)) {
                break;
            }
            System.out.println("Vous pouvez effectuer une autre capture. Mouvements possibles : " + mouvementsPossibles);
        }

        tourJoueur1 = !tourJoueur1;

        finDuJeu();
    }

    private boolean peutEffectuerCapture(int caseDepart, List<Integer> mouvementsPossibles) {
        for (int pos : mouvementsPossibles) {
            int delta = pos - 1 - caseDepart;
            if (Math.abs(delta) == 10 || Math.abs(delta) == 12) {
                return true;
            }
        }
        return false;
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

class Piece {
    private String couleur; // "Noir" ou "Blanc"

    public Piece(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return couleur.equals("Noir") ? "N" : "B";
    }
}

class Case {
    private Piece piece; // Peut être null si la case est vide

    public Case() {
        this.piece = null; // Par défaut, la case est vide
    }

    public void placerPiece(Piece piece) {
        this.piece = piece;
    }

    public void enleverPiece() {
        this.piece = null;
    }

    public boolean estVide() {
        return piece == null;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return (piece == null) ? "." : piece.toString();
    }
}

public class Plateau {
    private Case[][] plateau; // Plateau 8x8

    public Plateau() {
        this.plateau = new Case[8][8];
        initialiserPlateau();
    }

    private void initialiserPlateau() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                plateau[i][j] = new Case();

                // Placement des pièces noires (rangées 0,1,2)
                if (i < 3 && (i + j) % 2 == 1) {
                    plateau[i][j].placerPiece(new Piece("Noir"));
                }

                // Placement des pièces blanches (rangées 5,6,7)
                if (i > 4 && (i + j) % 2 == 1) {
                    plateau[i][j].placerPiece(new Piece("Blanc"));
                }
            }
        }
    }

    public void afficherPlateau() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Plateau p = new Plateau();
        p.afficherPlateau();
    }
}

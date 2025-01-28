// Classe représentant une pièce
class Piece {
    private String type; // Exemple : "Blanc" ou "Noir"

    public Piece(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

// Classe représentant une case du plateau
public class Case {
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
}

public class Case {
    private final int id;
    private Piece piece;

    public Case(int id, Piece piece) {
        this.id = id;
        this.piece = piece;
    }

    public int getId() {
        return id;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean estVide(){
        return piece == null;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void retirerPiece(){
        this.piece = null;
    }
}
import java.util.List;

public abstract class Piece {
    private final String color;

    public Piece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract String getType();

    public abstract List<Integer> mouvementsPossibles(int position, List<Case> plateau);
}
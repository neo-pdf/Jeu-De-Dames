import java.util.ArrayList;
import java.util.List;

public class Pion extends Piece{
    public Pion(String color) {
        super(color);
    }

    public String getType() {
        return "Pion";
    }

    public List<Integer> mouvementsPossibles(int position) {
        List<Integer> mouvements = new ArrayList<>();

        if (getColor().equals("R")) {
            int[] deltas = {5, 6};

            for (int delta : deltas) {
                int newPos = position + delta;
                if (newPos < 50 && plateau.getPlateau().get(newPos).estVide()) {
                    mouvements.add(newPos);
                }
        return mouvements;
    }
}

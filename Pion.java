import java.util.ArrayList;
import java.util.List;

public class Pion extends Piece {
    public Pion(String color) {
        super(color);
    }

    public String getType() {
        return "Pion";
    }

    public List<Integer> mouvementsPossibles(int position, List<Case> plateau) {
        List<Integer> mouvements = new ArrayList<>();
        int[] deltas = getColor().equals("R") ? new int[]{5, 6} : new int[]{-5, -6};

        for (int delta : deltas) {
            int newPos = position + delta;
            if (newPos >= 0 && newPos < 50 && plateau.get(newPos).estVide() && estMouvementValide(position, newPos)) {
                mouvements.add(newPos + 1);
            }
        }
        return mouvements;
    }

    private boolean estMouvementValide(int position, int newPos) {
        int colonneDepart = position / 5;
        int colonneArrivee = newPos / 5;
        return Math.abs(colonneDepart - colonneArrivee) == 1;
    }
}
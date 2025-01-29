import java.util.ArrayList;
import java.util.List;

public class Dame extends Piece {
    public Dame(String color) {
        super(color);
    }

    public String getType() {
        return "Dame";
    }

    public List<Integer> mouvementsPossibles(int position, List<Case> plateau) {
        List<Integer> mouvements = new ArrayList<>();
        int[] directions = {5, 6, -5, -6};

        for (int direction : directions) {
            int newPos = position + direction;
            while (newPos >= 0 && newPos < 50 && plateau.get(newPos).estVide() && estMouvementValide(position, newPos)) {
                mouvements.add(newPos + 1);
                newPos += direction;
            }
        }
        return mouvements;
    }

    private boolean estMouvementValide(int position, int newPos) {
        int colonneDepart = position / 5;
        int colonneArrivee = newPos / 5;
        return Math.abs(colonneDepart - colonneArrivee) == Math.abs((position % 5) - (newPos % 5));
    }
}
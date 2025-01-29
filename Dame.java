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
                mouvements.add(newPos + 1); // Ajouter 1 a l'index
                newPos += direction;
            }
            // Vérifier les captures
            if (newPos >= 0 && newPos < 50 && !plateau.get(newPos).estVide() && !plateau.get(newPos).getPiece().getColor().equals(getColor())) {
                int capturePos = newPos + direction;
                if (capturePos >= 0 && capturePos < 50 && plateau.get(capturePos).estVide() && estMouvementValide(position, capturePos)) {
                    mouvements.add(capturePos + 1); // Ajouter 1 a l'index
                }
            }
        }
        return mouvements;
    }

    private boolean estMouvementValide(int position, int newPos) {
        int rowDepart = position / 5;
        int rowArrivee = newPos / 5;
        return Math.abs(rowDepart - rowArrivee) == Math.abs((position % 5) - (newPos % 5));
    }
}
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
        int[] captureDeltas = getColor().equals("R") ? new int[]{10, 12} : new int[]{-10, -12};

        for (int delta : deltas) {
            int newPos = position + delta;
            if (newPos >= 0 && newPos < 50 && plateau.get(newPos).estVide() && estMouvementValide(position, newPos)) {
                mouvements.add(newPos + 1); // Ajouter 1 a l'index
            }
        }

        for (int captureDelta : captureDeltas) {
            int newPos = position + captureDelta / 2;
            int capturePos = position + captureDelta;
            if (newPos >= 0 && newPos < 50 && capturePos >= 0 && capturePos < 50 &&
                    !plateau.get(newPos).estVide() && !plateau.get(newPos).getPiece().getColor().equals(getColor()) &&
                    plateau.get(capturePos).estVide() && estMouvementValide(position, capturePos)) {
                mouvements.add(capturePos + 1); // Ajouter 1 a l'index
            }
        }

        return mouvements;
    }

    private boolean estMouvementValide(int position, int newPos) {
        int rowDepart = position / 5;
        int rowArrivee = newPos / 5;
        return Math.abs(rowDepart - rowArrivee) == 1 || Math.abs(rowDepart - rowArrivee) == 2;
    }
}
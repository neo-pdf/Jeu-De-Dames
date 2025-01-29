import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private final List<Case> plateau;

    public Plateau() {
        this.plateau = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            if (i < 20) {
                this.plateau.add(new Case(i + 1, new Pion("R")));
            } else if (i < 30){
                this.plateau.add(new Case(i + 1, null));
            } else {
                this.plateau.add(new Case(i +1, new Pion("V")));
            }
        }
    }

    public void affichePlateau() {
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i + j) % 2 == 0) {
                    if (index < plateau.size()) {
                        Case currentCase = plateau.get(index);
                        if (currentCase.getPiece() != null) {
                            System.out.print("[" + currentCase.getPiece().getColor() + currentCase.getPiece().getType().charAt(0) + "(" + (index + 1) + ")]");
                        } else {
                            System.out.print("[   " + (index + 1) + " ]");
                        }
                        index++;
                    }
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public List<Case> getPlateau() {
        return plateau;
    }
}
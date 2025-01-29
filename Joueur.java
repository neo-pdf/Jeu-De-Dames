import java.util.Objects;
import java.util.Scanner;

public class Joueur {
    private String nom;
    private String couleur;
    private int pieceRestante;

    public Joueur() {
        this.nom = "Joueur";
        this.pieceRestante = 20;
    }

    public String getNom() {
        return nom;
    }
    public void setNom() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (!input.isEmpty()) {
            this.nom = input;
        }

        System.out.println("Votre nom est maintenant " + this.getNom() + " !");
    }

    public int getPieceRestante() {
        return pieceRestante;
    }

    public void setPieceRestante(int pieceRestante) {
        this.pieceRestante = pieceRestante;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}

public class Pion extends Piece {

    public Pion(String color) {
        super(color);
        this.type = "Pion";
    }

    @Override
    public void promoteToDame() {
        System.out.println("Promotion du Pion en Dame...");
        // Logic to promote this Pion to a Dame can be implemented here.
    }
}

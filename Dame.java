public class Dame extends Piece {

    public Dame(String color) {
        super(color);
        this.type = "Dame";
    }

    @Override
    public void promoteToDame() {
        System.out.println("Cette pièce est déjà une Dame!");
    }
}

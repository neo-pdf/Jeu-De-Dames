public class Piece {
    protected String type;  // Indicates the type of piece
    protected String color; // Indicates the color of the piece

    public Piece(String color) {
        this.color = color;
        this.type = "Piece"; // Default type
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void promoteToDame() {
        // Placeholder for promotion logic, overridden in subclasses
    }
}

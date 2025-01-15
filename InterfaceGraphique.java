import javax.swing.*;
import java.awt.*;

public class InterfaceGraphique {
    public static void main(String[] args) {
        createFrame frame = new createFrame();
    }
}
class createFrame extends JFrame{
    public createFrame() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Jeu de dames");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(false);
        this.getContentPane().setBackground(new Color(153, 255, 204));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}


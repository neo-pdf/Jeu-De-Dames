import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InterfaceGraphique {
    private final JFrame frame;
    private final JPanel panelPlateau;
    private final Plateau plateau;

    public InterfaceGraphique(Plateau plateau) {
        this.plateau = plateau;
        frame = new JFrame("Jeu de dames");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        panelPlateau = new JPanel(new GridLayout(10, 10));
        initPlateau();
        frame.add(panelPlateau, BorderLayout.CENTER);
    }

    public void initFrame() {
        frame.setVisible(true);
    }

    private void initPlateau() {
        List<Case> cases = plateau.getPlateau();
        int index = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JPanel casePanel = new JPanel();
                casePanel.setBackground((i + j) % 2 == 0 ? Color.BLACK : Color.WHITE);

                if ((i + j) % 2 == 0 && index < cases.size()) {
                    Case currentCase = cases.get(index);
                    JButton pieceButton = new JButton();
                    pieceButton.setPreferredSize(new Dimension(60, 60));
                    if (currentCase.getPiece() != null) {
                        pieceButton.setBackground(currentCase.getPiece().getColor().equals("R") ? Color.RED : Color.GREEN);
                        pieceButton.addActionListener(new PieceButtonListener(currentCase));
                    } else {
                        pieceButton.setBackground(Color.WHITE);
                    }
                    casePanel.add(pieceButton);
                    panelPlateau.add(casePanel);
                    index++;
                }
            }
        }
    }

    public void mettreAJourPlateau() {
        panelPlateau.removeAll(); // Retire tous les composants
        initPlateau(); // Réinitialise le plateau
        panelPlateau.revalidate(); // Réaffiche le plateau
        panelPlateau.repaint(); // Repeint le plateau
    }

    private class PieceButtonListener implements ActionListener {
        private final Case pieceCase;

        public PieceButtonListener(Case pieceCase) {
            this.pieceCase = pieceCase;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Afficher les cases possibles pour la pièce
            afficherCasesPossibles(pieceCase);
        }
    }

    private void afficherCasesPossibles(Case pieceCase) {
        // Logique pour déterminer et afficher les cases possibles
        System.out.println("Afficher les cases possibles pour la pièce sur la case: " + pieceCase.getId());
        // Ajoute la logique ici pour mettre en surbrillance les cases possibles
    }
}

package gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.main.GameMain;
import model.Player;

public class PieceColorPanel extends JPanel {

    private BorderLayout layout = new BorderLayout(1, 0);

    public PieceColorPanel(Player player) {
        super();
        setLayout(layout);
        setBackground(GameMain.SFONDO);
        JPanel piece = new PieceColor(player);

        JLabel icon = new JLabel("Color: ");
        icon.setFont(GameMain.COURIER);

        add(icon, BorderLayout.CENTER);
        add(piece, BorderLayout.LINE_END);

        setVisible(true);

    }

}

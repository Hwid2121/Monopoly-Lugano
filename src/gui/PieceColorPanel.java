package gui;

import model.Player;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * PieceColorPanel where the piece of the player is showned.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class PieceColorPanel extends JPanel {

    private BorderLayout layout = new BorderLayout(1, 0);

    /**
     * Constructor of the PieceColorPanel.
     * @param player the player that have to be showned.
     */
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

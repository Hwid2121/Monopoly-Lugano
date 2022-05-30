package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import model.Player;

/**
 * PieceColor panel where the piece of the player is showned.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class PieceColor extends JPanel {

    private Color color;

    /**
     * Constructor of the PieceColorPanel.
     * 
     * @param player the player that have to be showned.
     */
    public PieceColor(Player player) {
        super();

        color = player.getPiece().getColor();
        this.setPreferredSize(new Dimension(30, 30));

    }

    /**
     * Paint the piece of the player.
     * 
     * @param graphicsVar the graphics of the panel
     */
    public void paint(Graphics graphicsVar) {

        Graphics2D piece = (Graphics2D) graphicsVar;

        piece.setPaint(color);
        piece.fillOval(0, 0, 30, 30);
        setVisible(true);

    }

}

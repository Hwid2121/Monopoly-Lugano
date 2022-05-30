package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.Player;

public class PieceColor extends JPanel {

    private Color color;

    public PieceColor(Player player) {
        super();

        color = player.getPiece().getColor();
        this.setPreferredSize(new Dimension(30, 30));

    }

    public void paint(Graphics g) {

        Graphics2D piece = (Graphics2D) g;

        piece.setPaint(color);
        piece.fillOval(0, 0, 30, 30);
        setVisible(true);

    }

}

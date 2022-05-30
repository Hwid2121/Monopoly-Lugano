package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.Monopoly;
import model.Player;

/**
 * MonopolyGridPanel the panel that contains the grid of the game.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class MonopolyGridPanel extends JPanel implements ActionListener {

    private GridPosition gridpos = new GridPosition();

    private Monopoly monopoly = GameMain.monopoly;

    private Image backgroundImage;

    /**
     * Constructor MonopolyGridPanel.
     * 
     * @param playerz the player that is playing the game
     */
    public MonopolyGridPanel(Player playerz) {
        super();
        backgroundImage = new ImageIcon("src/gui/images/monopolygrid1000.png").getImage();

    }

    /**
     * Paint the grid of the game.
     * 
     * @param graphicsVar the graphics of the panel
     */
    public void paint(Graphics graphicsVar) {
        super.paint(graphicsVar);
        Graphics2D pan = (Graphics2D) graphicsVar;

        pan.drawImage(backgroundImage, 0, 0, null);

        for (Player player : monopoly.getListOfPlayer()) {

            pan.setPaint(player.getPiece().getColor());
            pan.fillOval(gridpos.getPosition(player.getPosition()).getX(),
                    gridpos.getPosition(player.getPosition()).getY(), 30, 30);

        }

    }

    /**
     * Action performed when the user click on the grid.
     * 
     * @param actionEvent the action event
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {

    }

}

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

public class MonopolyGridPanel extends JPanel implements ActionListener {

    private GridPosition gridpos = new GridPosition();

    private Monopoly monopoly = GameMain.monopoly;

    private Image backgroundImage;

    public MonopolyGridPanel(Player playerz) {
        super();
        backgroundImage = new ImageIcon("src/gui/images/monopolygrid1000.png").getImage();

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D pan = (Graphics2D) g;

        pan.drawImage(backgroundImage, 0, 0, null);

        for (Player player : monopoly.getListOfPlayer()) {

            pan.setPaint(player.getPiece().getColor());
            pan.fillOval(gridpos.getPosition(player.getPosition()).getX(),
                    gridpos.getPosition(player.getPosition()).getY(), 30, 30);

        }

    }

    public void setStep(int i) {

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }

}

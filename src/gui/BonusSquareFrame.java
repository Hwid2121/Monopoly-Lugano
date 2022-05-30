package gui;

import model.Player;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * BonusSquare frame to show the description of the bonusSQUare.
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class BonusSquareFrame extends JFrame {

    private Player player;




    /**
     * Constructor of the BonusSquareFrame.
     * 
     * @param parentPanel the parent of frame
     * @param playera the player
     */
    public BonusSquareFrame(MonopolyCommandsPanel parentPanel, Player playera) {
        super();

        player = playera;
        MonopolyCommandsPanel parentPan = parentPanel;


        setVisible(false);
        setPreferredSize(new Dimension(500, 150));
        setResizable(false);

        setLocationRelativeTo(null);
        this.getContentPane().setBackground(GameMain.SFONDO);
        BoxLayout laymain = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        setLayout(laymain);
        setUndecorated(true);

        JLabel label = new JLabel("BONUS SQUARE: ");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        label.setSize(new Dimension(40, 40));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel panel = new BonusSquarePanel(parentPan, this, player);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(label);
        add(panel);

        pack();

    }

}

package gui;

import model.Monopoly;
import model.Player;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * InfoSquareFrame frame tjat show info of the square.
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class InfoSquareFrame extends JFrame implements ActionListener {

    private JPanel panel;

    /**
     * Construcotr of the frame InfoSquareFrame.
     * 
     * @param parentPanel the parent panel
     * @param player the player
     * @param monopolya the monopoly
     */
    public InfoSquareFrame(MonopolyCommandsPanel parentPanel, Player player, Monopoly monopolya) {

        super();
        Monopoly monopoly = monopolya;
        panel = new InfoSquarePanel(player, this, monopoly);

        setVisible(false);
        setPreferredSize(new Dimension(900, 350));
        setResizable(false);

        setLocationRelativeTo(null);
        this.getContentPane().setBackground(GameMain.SFONDO);
        BoxLayout laymain = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        setLayout(laymain);
        setUndecorated(true);

        JLabel label = new JLabel("INFO SQUARE: ");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setSize(new Dimension(20, 20));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(label);
        add(panel);

        pack();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }

}

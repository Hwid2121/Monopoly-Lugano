package gui;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.main.GameMain;
import model.Monopoly;
import model.Player;

/**
 * BonusSquarePanel that contains the frameBOnus.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class BonusSquarePANEL extends JPanel implements ActionListener {

    private JLabel desc;
    final private BonusSquareFrame framea;
    private JButton button;
    private Font sansSerif= new Font("SansSerif", Font.BOLD, 14);

    private Player player;
    private int price;

    private Monopoly monopoly = GameMain.monopoly;

    public BonusSquarePANEL(MonopolyCommandsPanel frameB, BonusSquareFrame frameA, Player players) {
        super();

        this.player = players;
        price = monopoly.getTable().getSquareBonusPrice(player);

        this.framea = frameA;

        BoxLayout lay = new BoxLayout(this, BoxLayout.Y_AXIS);

        setLayout(lay);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBackground(GameMain.SFONDO);

        button = new JButton("CONTINUE");
        button.setForeground(GameMain.CREMISI);
        button.setFont(sansSerif);
        button.setMinimumSize(new Dimension(120, 40));
        button.setPreferredSize(new Dimension(120, 40));

        desc = new JLabel(GameMain.monopoly.getTable().getSquareBonusDescr(player.getPosition()));
        desc.setFont(sansSerif);
        desc.setAlignmentX(Component.CENTER_ALIGNMENT);
        bonusPlay();
        add(desc);
        add(Box.createRigidArea(new Dimension(0, 70)));
        add(button);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent eG) {

                framea.dispose();

            }
        });

    }

    public void bonusPlay() {

        if (monopoly.getTable().getSquare(player.getPosition()).getColor().equals("bonus")) {

            player.increaseMoney(price);
        } else {
            player.decreaseMoney(price);

        }

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }
}

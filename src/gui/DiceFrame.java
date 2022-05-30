package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Dice;



/**
 *  DiceFrame frame that shows the value of the DIce.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class DiceFrame extends JFrame implements ActionListener {

    private Dice dice;


    /**
     * Constructor of the DiceFrame.
     * 
     * @param game the parent of the frame
     * @param dic the dice that have to be showned.
     */
    public DiceFrame(MonopolyCommandsPanel game, Dice dic) {

        super();

        dice = dic;


        setVisible(false);
        setPreferredSize(new Dimension(500, 150));
        setResizable(false);

        setLocationRelativeTo(null);
        this.getContentPane().setBackground(GameMain.SFONDO);
        BorderLayout laymain = new BorderLayout();
        setLayout(laymain);
        setUndecorated(true);

        
        JLabel label = new JLabel("YOUR DICE IS:  ");

        label.setForeground(Color.BLACK);
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        label.setSize(new Dimension(40, 40));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel dicePanel = new DicePanel(this, dice);
        add(label, BorderLayout.PAGE_START);
        add(dicePanel, BorderLayout.CENTER);

        pack();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }

}

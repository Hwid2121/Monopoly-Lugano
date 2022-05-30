package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import gui.main.GameMain;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Dice;

public class DiceFrame extends JFrame implements ActionListener {

    private Dice dice;

    public DiceFrame(MonopolyCommandsPanel game, Dice dic) {

        super();

        dice = dic;

        JPanel dicePanel = new DicePanel(this, dice);
        JLabel label = new JLabel("YOUR DICE IS:  ");

        setVisible(false);
        setPreferredSize(new Dimension(500, 150));
        setResizable(false);

        setLocationRelativeTo(null);
        this.getContentPane().setBackground(GameMain.SFONDO);
        BorderLayout laymain = new BorderLayout();
        setLayout(laymain);
        setUndecorated(true);

        label.setForeground(Color.BLACK);
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        label.setSize(new Dimension(40, 40));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(label, BorderLayout.PAGE_START);
        add(dicePanel, BorderLayout.CENTER);

        pack();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }

}

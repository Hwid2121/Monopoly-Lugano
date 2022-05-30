package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.BoxLayout;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import gui.main.GameMain;

import model.Card;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUpPickCardFrame extends JFrame implements ActionListener {

    public PopUpPickCardFrame(Card card, MonopolyCommandsPanel parentPanel) {

        super();

        MonopolyCommandsPanel parentPan = parentPanel;
        JPanel panel = new PopUpPickCardPanel(parentPan, this, card);

        setVisible(false);
        setPreferredSize(new Dimension(500, 150));
        setResizable(false);

        setLocationRelativeTo(null);
        this.getContentPane().setBackground(GameMain.SFONDO);
        BoxLayout laymain = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        setLayout(laymain);
        setUndecorated(true);

        JLabel label = new JLabel("CARD: ");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        label.setSize(new Dimension(40, 40));
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

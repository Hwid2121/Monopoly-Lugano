package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;


import javax.swing.JPanel;


import gui.main.GameMain;

import model.Card;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class EmptySquarePopUpFrame extends JFrame implements ActionListener  {

    private JPanel pop;
    private Font s = new Font("SansSerif", Font.BOLD, 14);
    

    public EmptySquarePopUpFrame(MonopolyCommandsPanel parentPanel){

        super();
        // JButton button ;
        MonopolyCommandsPanel parentPan = parentPanel;
        JPanel panel  = new EmptySquarePopUpPanel(parentPan, this);

        
        setVisible(false);
        setPreferredSize(new Dimension(500, 150));
        setResizable(false);
        
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(GameMain.SFONDO);
        BoxLayout laymain = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        setLayout(laymain);
        setUndecorated(true);

        JLabel label = new JLabel("EMPTY SQUARE");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        label.setSize(new Dimension(40, 40));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        // panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        
        
        add(label);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(panel);
        // add(Box.createRigidArea(new Dimension(5, 20)));
        // add(panel);

        


        pack();
        // setVisible(false);

        


        

        
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        
    }
}

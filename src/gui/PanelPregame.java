package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.colorchooser.*;
import java.awt.Color;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.Box;

public class PanelPregame  extends JPanel {

     private final Dimension dim = new Dimension(300 , 300);
    

    
    
    public PanelPregame(){

         
        JButton jb1 = new JButton("Play!");
        JButton jb2 = new JButton("Rules");

        // BorderLayout layoutButtons = new BorderLayout();
        


        BoxLayout laybut = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(laybut);

        

        add(jb1);
        add(jb2);


        jb1.setSize(300, 300);
        jb2.setSize(300,300);




        setBackground(CLayout.SFONDO);
        





    }   
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    
}

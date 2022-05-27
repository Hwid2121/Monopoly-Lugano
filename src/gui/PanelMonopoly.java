package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.colorchooser.*;
import javax.swing.plaf.ButtonUI;

import java.awt.Color;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.image.BufferedImage;
import javax.swing.SpringLayout;

public class PanelMonopoly extends JPanel {

    

    

    PanelMonopoly(){

        JButton button1 = new JButton("NORTH");
        JButton button2 = new JButton("END-LINE");



        button2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        JButton button3 = new JButton("SOUTH");

        GridLayout colsx= new GridLayout(1,10);
        GridLayout rowup= new GridLayout(10,1);
        // GridLayout coldx= new GridLayout();

        JPanel monopolyGridPanel = new MonopolyGridPanel();
        JPanel monopolyPlayerPanel = new MonopolyPlayerPanel();
        JPanel monopolyCommandsPanel = new MonopolyCommandsPanel();


        BorderLayout mainLay = new BorderLayout(10,10);
        setLayout(mainLay);

        // System.out.println(this);



        add(monopolyGridPanel, BorderLayout.CENTER);

        add(button2, BorderLayout.LINE_END);
        add(button3, BorderLayout.PAGE_END);



    }



    
}

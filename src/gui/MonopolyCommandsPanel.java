
package gui;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Painter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
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

import gui.main.GameMain;

import java.awt.Color;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
// import java.io.*;
import java.awt.ComponentOrientation;
import java.awt.Container;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.image.BufferedImage;
import javax.swing.SpringLayout;


import javax.swing.JPanel;

public class MonopolyCommandsPanel extends JPanel {




    JButton button1 = new JButton("Trow the dice");

    Dimension dim = new Dimension(130,100);
    Border blackline = BorderFactory.createLineBorder(GameMain.CREMISI);
    Font courier = new Font("SansSerif", Font.BOLD, 22);

    // JButton button4;
    // JButton button5;

    public MonopolyCommandsPanel(){


        FlowLayout layout  = new FlowLayout(FlowLayout.CENTER,10,50 );
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        setBackground(GameMain.SFONDO);

        setBorder(blackline);
        setLayout(layout);
        setFont(courier);

        button1.setPreferredSize(dim);




        this.add(button1);




        setVisible(true);




        


    }


}

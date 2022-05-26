package gui;
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

public class PanelPlayers extends JPanel {


    private BorderLayout mainlayout = new BorderLayout();
    private JPanel mainPanel = new JPanel();


    public PanelPlayers(){

    
    mainPanel.setLayout(mainlayout);
    mainPanel.setBackground(Color.BLUE);

    JButton button = new JButton("Button 1 (PAGE END)");
    mainPanel.add(button, BorderLayout.PAGE_END);

    button = new JButton("Button 2 (CENTER)");
    button.setPreferredSize(new Dimension(200, 100));
    mainPanel.add(button, BorderLayout.CENTER);



    button = new JButton("5 (LINE_END)");
    mainPanel.add(button, BorderLayout.LINE_END);


    
    mainPanel.setVisible(true);

    }


}
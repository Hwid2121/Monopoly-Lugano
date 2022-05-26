package gui;

import javax.swing.JFrame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
import java.awt.FlowLayout;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.image.BufferedImage;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.Popup;
import javax.swing.PopupFactory;

import java.awt.TextField;

public class NumPlayerFrame  extends JFrame  {


    private JPanel panel = new FormPanel();
    public NumPlayerFrame(){
        
        setVisible(false);
        setPreferredSize(new Dimension(500, 150));
        setResizable(false);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(GameMain.CREMISI);
        setUndecorated(true);


       

        BoxLayout laymain = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);
        setLayout(laymain);
        
        JLabel label = new JLabel("Insert the number of players:");
        label.setForeground(Color.WHITE);
        label.setFont(new Font ("SansSerif", Font.BOLD, 22));
        label.setSize(new Dimension(40,40));

        

        add(label);
        add(panel);
        
        pack();
        setVisible(false);

    }

}

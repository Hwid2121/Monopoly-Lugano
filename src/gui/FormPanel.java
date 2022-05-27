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


import model.*;

public class FormPanel extends JPanel{


    private JButton button;
    private JTextField textField;
    private NumPlayerFrame frame;
    
    public FormPanel(NumPlayerFrame frameA){

        super();
        this.frame = frameA;
        
        FlowLayout lay = new FlowLayout();
        setLayout(lay);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBackground(GameMain.SFONDO);
        button = new JButton("Submit");
        button.setUI(GameMain.BUTTON_STYLE);
        button.setMinimumSize(new Dimension(100,40));
        button.setPreferredSize(new Dimension(100,40));
        
        textField = new JTextField();

        


        textField.setPreferredSize(new Dimension(50,40));
        textField.setAlignmentX(CENTER_ALIGNMENT);
        textField.setFont(new Font ("SansSerif", Font.BOLD, 22));

        add(textField);
        add(button);
        setVisible(true);



        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                System.out.println("number: " + textField.getText());

                String s = textField.getText();
                try {
                    
                    int num =Integer.parseInt(s);
                    System.out.println("An integer");
                    GameMain.monopoly.setNumOfPlayers(num);
                    frame.dispose();

                    
                    
                    
                      



                    

                    
               }
               catch (NumberFormatException error) {
                    //Not an integer
               }
                 
            }
        });


        


    }

    public void closeFrame(){
        SwingUtilities.getWindowAncestor(this).dispose(); 
    }
        
        
    

}